package com.musu.web;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.ProductsEntity;
import com.musu.model.Reviews;
import com.musu.model.User;
import com.musu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/productDetails"})
    public String showProduct(Model model) {
        return "productDetails";
    }

    @RequestMapping(value = {"/{category}/{name}"},method = RequestMethod.GET )
    public String showproduct(@PathVariable("name")String productname,@PathVariable("category")String category,Model model) {
        String categoryname=category;
        ProductcategoriesEntity catName=categoryService.findCategoryByName(categoryname);
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        ProductsEntity product = productService.findByName(productname);
        int productId=product.getProductId();
        List<Reviews> reviews= reviewService.findReviewsByProductId(productId);
        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("product",product);
        model.addAttribute("reviews",reviews);
        return "productDetails";
    }

    @RequestMapping(value = {"/review/{productName}"}, method = RequestMethod.POST)
    public String addReview(@RequestParam("comment") String comment, Model model,@PathVariable("productName")String productName) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        ProductsEntity productsEntity = productService.findByName(productName);
        User user = userService.findByUsername(username);
        Reviews reviews = new Reviews();
        reviews.setUser(user);
        reviews.setProductsEntity(productsEntity);
        reviews.setReview(comment);
        reviewService.save(reviews);
        return "redirect:/review/{productName}";
    }
}
