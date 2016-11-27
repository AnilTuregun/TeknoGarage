package com.musu.web;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.ProductsEntity;
import com.musu.model.User;
import com.musu.service.CategoryService;
import com.musu.service.ProductService;
import com.musu.service.SecurityService;
import com.musu.service.UserService;
import com.musu.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
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
public class UserController {
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

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signUp";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();

        model.addAttribute("category",productCategoryEntitiyList);
        return "home";
    }

    @RequestMapping(value = {"/welcome"})
    public String showwelcome(Model model) {
        model.addAttribute("userForm", new User());
        return "welcome";
    }
    @RequestMapping(value={"/loggedout"})
    public String showLoggedOut(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    @RequestMapping(value = {"/home"})
    public String showhome(Model model) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        List<ProductsEntity> productEntitiyList = productService.findAll();

        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);
        return "home";
    }



    @RequestMapping(value = {"/category/{id}"},method = RequestMethod.GET )
    public String showcategory(@PathVariable("id")int id,Model model) {
       List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        List<ProductsEntity> productEntitiyList = productService.findByCateogoryId(id);

        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("products",productEntitiyList);
        return "home";
    }
}
