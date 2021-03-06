package com.musu.web;

import com.musu.model.*;
import com.musu.repository.ProductsRepository;
import com.musu.repository.UserRepository;
import com.musu.service.*;
import com.musu.validator.ProductEditValidator;
import com.musu.validator.ProductValidator;
import com.musu.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Autowired
    private SliderService sliderService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductValidator productValidator;
    @Autowired
    private ProductEditValidator productEditValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private RoleService roleService;
    private int productId;


    @RequestMapping(value = {"/adminpanel/productlist"},method = RequestMethod.GET)
    public String showProductList(Model model,HttpSession session) {
        List<ProductsEntity> productEntityList = productService.findAll();
        model.addAttribute("products",productEntityList);
        return "productlist";
    }
    @RequestMapping(value = {"/adminpanel/userlist"},method = RequestMethod.GET)
    public String showUsers(Model model,HttpSession session) {
        List<User> userList = userService.findAll();
        model.addAttribute("users",userList);
        return "userlist";
    }
    @RequestMapping(value = {"/adminpanel/commentList"},method = RequestMethod.GET)
    public String showComment(Model model,HttpSession session) {
        List<Reviews> reviewsList=reviewService.findAll();
        model.addAttribute("comments",reviewsList);
        return "comments";
    }
    @RequestMapping(value ="/deleteComment/{commentId}")
    public String deleteComment(@PathVariable("commentId") int id,Model model){
       Reviews reviews=reviewService.findReview(id);
        reviewService.deleteComment(reviews.getId());
        List<Reviews> reviewsList=reviewService.findAll();
        model.addAttribute("comments",reviewsList);
        return "comments";
    }
    @RequestMapping(value ="/deleteUser/{userName}")
    public String deleteUser(@PathVariable("userName") String userName,Model model){
      User user=userRepository.findByUsername(userName);
     userService.deleteUser(user.getId());
        List<User> userList = userService.findAll();
        model.addAttribute("users",userList);
        return "userlist";
    }
    @RequestMapping(value = {"/adminpanel"},method = RequestMethod.GET)
    public String showAdminPanel(Model model,HttpSession session) {
        List<OrdersEntity> orders= orderService.findAll();
        List<Reviews> reviews= reviewService.findAll();
        List<User> users=userService.findAll();
        model.addAttribute("review",reviews);
        model.addAttribute("order",orders);
        model.addAttribute("user",users);

        return "adminpanel";
}
    @RequestMapping(value = "/adminpanel/addProduct",method = RequestMethod.GET)
    public String addProduct1(Model model) {


        List<ProductcategoriesEntity> categori=categoryService.findAll();
        List<String> categoriName = new ArrayList<>();
        for(int i=0;i<categori.size();i++){
            categoriName.add(categori.get(i).getCategoryName());
        }
        model.addAttribute("categoriList",categoriName);
        model.addAttribute("productForm", new ProductsEntity());
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productForm") ProductsEntity product, BindingResult result, Model model) {
          productValidator.validate(product,result);
        ProductsEntity productsEntity1=productService.findBySkuNumber(product.getProductSku());
        if (result.hasErrors()) {
            return "addProduct";
        }
        ProductsEntity productsEntity=product;
        ProductcategoriesEntity productcategoriesEntity=categoryService.findCategoryByName(product.getProductcategoriesByProductCategoryId().getCategoryName());
        productsEntity.setProductcategoriesByProductCategoryId(productcategoriesEntity);

        String input = productsEntity.getProductImage();
        int lastIndexOfSlash = input.lastIndexOf('/');
        String result1 = input.substring(0, lastIndexOfSlash + 1) + "resources/image/" + input.substring(lastIndexOfSlash + 1);
        productsEntity.setProductImage(result1);
        productService.save(productsEntity);

        return "redirect:/adminpanel/productlist";
    }

@RequestMapping(value ="/deleteProduct/{productName}")
    public String deleteProduct(@PathVariable("productName") String pName,Model model){
    ProductsEntity productsEntity=productService.findByName(pName);
    int pId=productsEntity.getProductId();
    productService.deleteProduct(pId);
    List<ProductsEntity> productEntityList = productService.findAll();
    model.addAttribute("products",productEntityList);
    return "productlist";
}
    @RequestMapping(value = "/adminPanel/editProduct/{productName}",method = RequestMethod.GET)
    public String updateProduct(Model model,@PathVariable("productName") String pName,HttpSession session) {
        List<ProductcategoriesEntity> categori=categoryService.findAll();
        List<String> categoriName = new ArrayList<>();
        for(int i=0;i<categori.size();i++){
            categoriName.add(categori.get(i).getCategoryName());
        }
        model.addAttribute("categoriList",categoriName);
        ProductsEntity productsEntity=productService.findByName(pName);
        model.addAttribute("editproductForm",productsEntity);
        session.setAttribute("skuNumber",productsEntity.getProductSku());
        session.setAttribute("productImg",productsEntity.getProductImage());
        return "editProduct";
    }

    @RequestMapping(value = "/adminPanel/editProduct",method = RequestMethod.POST)
    public String updateProduct1(@ModelAttribute("editproductForm") ProductsEntity product, BindingResult result, Model model,HttpSession session) {
        productEditValidator.validate(product,result);
      int id=product.getProductId();
        if (result.hasErrors()) {
            return "editProduct";
        }
        if((!product.getProductSku().equals(session.getAttribute("skuNumber")))&&(productService.findBySkuNumber(product.getProductSku())!=null))
        {
            result.rejectValue("productSku", "Duplicate.productForm.productSku");
        }
        String img=product.getProductImage();
        if(img.equals("")){
            String productImg=(String) session.getAttribute("productImg") ;
            product.setProductImage(productImg);
        }
            else {
            int lastIndexOfSlash = img.lastIndexOf('/');
                    String result1 = img.substring(0, lastIndexOfSlash + 1) + "resources/image/" + img.substring(lastIndexOfSlash + 1);
                     product.setProductImage(result1);
        }
        ProductsEntity productsEntity=product;
        ProductcategoriesEntity productcategoriesEntity=categoryService.findCategoryByName(product.getProductcategoriesByProductCategoryId().getCategoryName());
        productsEntity.setProductcategoriesByProductCategoryId(productcategoriesEntity);
        productsEntity.setProductcategoriesByProductCategoryId(productcategoriesEntity);
        productService.save(product);

        return "productlist";
    }
    @RequestMapping(value = "/adminpanel/slider",method = RequestMethod.GET)
    public String showSlider(Model model){

            List<Slider> sliderList =sliderService.findAll();
                model.addAttribute("sliders",sliderList);
        return "slider";
    }
    @RequestMapping(value = "/adminpanel/deleteslider/{SliderId}")
    public String deleteSlider(@PathVariable("SliderId")int id,Model model ){

        sliderService.deleteSlider(id);
        List<Slider> sliderList =sliderService.findAll();
        model.addAttribute("sliders",sliderList);
            return  "redirect:/adminpanel/slider";
    }

    @RequestMapping(value = "/adminpanel/addslider",method = RequestMethod.GET)
    public String addSlider(Model model){


        model.addAttribute("slider", new Slider());

        return "addslider";
    }

    @RequestMapping(value = "/adminpanel/addslider",method = RequestMethod.POST)
    public String addSlider1(@ModelAttribute("slider") Slider slider,Model model, BindingResult result){


        sliderService.save(slider);
        return "addslider";
    }

    @RequestMapping(value = {"/adminpanel/addAdmin"},method = RequestMethod.GET)
    public String ShowaddAdmin(Model model,HttpSession session) {
        model.addAttribute("adminForm", new User());
        return "AdminSignUp";
    }
    @RequestMapping(value = {"/adminpanel/addAdmin"},method = RequestMethod.POST)
    public String addAdmin(@ModelAttribute("adminForm") User userForm, BindingResult bindingResult, Model model,HttpSession session) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        Role role =roleService.findRoleByName("ROLE_ADMIN");
        userForm.setRole(role);
        userService.save(userForm);
        return "adminpanel";
    }

}
