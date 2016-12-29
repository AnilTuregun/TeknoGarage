package com.musu.web;

import com.musu.model.*;
import com.musu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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





        return "adminpanel";
}
    @RequestMapping(value = "/adminpanel/addProduct", method = RequestMethod.POST)
    public String addProduct(Model model) {

        model.addAttribute("productForm", new ProductsEntity());
        return "/adminpanel/productlist";
    }

}
