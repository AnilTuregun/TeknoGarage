package com.musu.web;

import com.musu.model.*;
import com.musu.service.*;
import com.musu.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SliderService sliderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping(value = {"/home"})
    public String showhome(Model model,HttpSession session) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        List<ProductsEntity> productEntitiyList = productService.findAll();
        ProductsEntity productsEntity=productService.findByName("Acer Chromebook");
        Set<Reviews> reviewsList=productsEntity.getReviews();
        List<ShoppingCart> shoppingCart=cartService.findAll();
        List<Slider> sliderList= sliderService.findActiveSlider();
        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);
        model.addAttribute("sliders",sliderList );

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        List<ShoppingCart> shoppingCarts=cartService.findCartByUser(username);

        session.setAttribute("shoppingCart",shoppingCarts);
        return "home";
    }

    @RequestMapping(value = {"/"})
    public String showhome1(Model model,HttpSession session) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        List<ProductsEntity> productEntitiyList = productService.findAll();
        List<Slider> sliderList= sliderService.findActiveSlider();
        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);
        model.addAttribute("sliders",sliderList );
        return "home";
    }

    }

