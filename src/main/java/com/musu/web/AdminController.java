package com.musu.web;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.ProductsEntity;
import com.musu.model.Reviews;
import com.musu.model.ShoppingCart;
import com.musu.service.CartService;
import com.musu.service.CategoryService;
import com.musu.service.ProductService;
import com.musu.service.ReviewService;
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

    private int productId;


    @RequestMapping(value = {"/productList"},method = RequestMethod.GET)
    public String showProduct(Model model,HttpSession session) {
        List<ProductsEntity> productEntityList = productService.findAll();
        model.addAttribute("products",productEntityList);
        return "productlist";
    }
    @RequestMapping(value = {"/adminpanel"},method = RequestMethod.GET)
    public String showAdminPanel(Model model,HttpSession session) {
        
        List<Reviews> reviews= reviewService.findAll();
        model.addAttribute("review",reviews);
        return "adminpanel";
}

}
