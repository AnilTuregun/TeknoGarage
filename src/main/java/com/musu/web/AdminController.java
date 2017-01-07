package com.musu.web;

import com.musu.model.*;
import com.musu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
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
    private int productId;


    @RequestMapping(value = {"/adminpanel/productlist"},method = RequestMethod.GET)
    public String showProduct(Model model,HttpSession session) {
        List<ProductsEntity> productEntityList = productService.findAll();
        model.addAttribute("products",productEntityList);
        return "productlist";
    }
    @RequestMapping(value = {"/adminpanel"},method = RequestMethod.GET)
    public String showAdminPanel(Model model,HttpSession session) {
        List<OrdersEntity> orders= orderService.findAll();
        List<Reviews> reviews= reviewService.findAll();
        List<User> users=userService.findAll();
        model.addAttribute("review",reviews);
        model.addAttribute("order",orders);
        model.addAttribute("user",users);



ProductsEntity a=new ProductsEntity();


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

  ProductsEntity productsEntity=product;
        ProductsEntity newProduct = new ProductsEntity();
        newProduct.setProductName(productsEntity.getProductName());
        newProduct.setProductLongDesc(productsEntity.getProductLongDesc());
        ProductcategoriesEntity productcategoriesEntity=categoryService.findCategoryByName(product.getProductcategoriesByProductCategoryId().getCategoryName());
        newProduct.setProductcategoriesByProductCategoryId(productcategoriesEntity);
        newProduct.setProductImage(product.getProductImage());
        productService.save(newProduct);
        return "/adminpanel/productlist";
    }


}
