package com.musu.web;

import com.musu.model.ProductcategoriesEntity;
import com.musu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CategoryService categoryService;



    @RequestMapping(value = {"/cart"})
    public String showhome(Model model, HttpSession session) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        model.addAttribute("category",productCategoryEntitiyList);
        return "cart";
    }
}
