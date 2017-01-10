package com.musu.web;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.ProductsEntity;

import com.musu.service.CategoryService;
import com.musu.service.ProductService;
import com.musu.service.SecurityService;
import com.musu.service.UserService;
import com.musu.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CategoriController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;



    @RequestMapping(value = {"categories/{name}"})
    public String showcategories(@PathVariable("name")String name,Model model) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        ProductcategoriesEntity category=categoryService.findCategoryByName(name);
        List<ProductsEntity> productEntitiyList = productService.findByCateogoryId(category.getCategoryId());

        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);
        return "categories";
    }

    @RequestMapping(value = {"/category/{name}"})
    public String showcategories2(@PathVariable("name")String name,Model model) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        ProductcategoriesEntity category=categoryService.findCategoryByName(name);
        List<ProductsEntity> productEntitiyList = productService.findByCateogoryId(category.getCategoryId());

        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);
        return "categories";
    }


}
