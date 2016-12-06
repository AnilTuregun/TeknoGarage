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
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;


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

        model.addAttribute("category",productCategoryEntitiyList);
        model.addAttribute("product",product);
        return "productDetails";
    }
}
