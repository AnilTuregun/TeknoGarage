package com.musu.web;

import com.musu.model.*;
import com.musu.repository.ProductcategoriesRepository;
import com.musu.service.*;
import com.musu.validator.UserValidator;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model,HttpSession session) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        Role role =roleService.findRoleByName("ROLE_USER");
        userForm.setRole(role);
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

    @RequestMapping(value = {"/userlist"})
    public String showUserlist(Model model) {
     List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userlist";
    }



    @RequestMapping(value={"/loggedout"})
    public String showLoggedOut(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        int total=0;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user =userService.findByUsername(username);
        model.addAttribute("user",user);
        return "account";
    }
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String accountEdit(@ModelAttribute("userForm")User user,Model model, BindingResult result) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        int total=0;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
       userService.save(user);

        return "home";
    }
    @RequestMapping(value = {"/myOrders"})
    public String showOrders (Model model,HttpSession session){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }


        List<OrdersEntity> ordersEntities=orderService.findOrdersbyUsername(username);
        model.addAttribute("orders",ordersEntities);




        return "myorders";
    }
    @RequestMapping(value = {"/myOrders/{OrderID}"})
    public  String showOrderDetails (@PathVariable("OrderID") int orderID,Model model){

        List<OrderDetailsEntity> orderDetailsEntities=orderDetailsService.findDetailsbyOrderID(orderID);
        model.addAttribute("orderDetails",orderDetailsEntities);

        return "orderdetails";
    }

}
