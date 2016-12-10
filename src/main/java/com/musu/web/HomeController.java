package com.musu.web;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.ProductsEntity;
import com.musu.model.ShoppingCart;
import com.musu.model.User;
import com.musu.service.*;
import com.musu.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;


    @RequestMapping(value = {"/home"})
    public String showhome(Model model,HttpSession session) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        List<ProductsEntity> productEntitiyList = productService.findAll();
        List<ShoppingCart> shoppingCart=cartService.findAll();
        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);
        model.addAttribute("shoppingCart",shoppingCart);
        return "home";
    }

    @RequestMapping(value = {"/"})
    public String showhome1(Model model,HttpSession session) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        List<ProductsEntity> productEntitiyList = productService.findAll();
        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);

        return "home";
    }

}
