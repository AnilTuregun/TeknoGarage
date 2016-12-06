package com.musu.web;


import com.musu.model.ProductcategoriesEntity;
import com.musu.model.ProductsEntity;
import com.musu.service.CategoryService;
import com.musu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by User on 3.12.2016.
 */
@Controller
public class SearchController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/searchProduct"})
    public String showSearchResults(Model model) {
        return "searchProduct";
    }

    @RequestMapping(value = {"/searchProduct"}, method = RequestMethod.GET)
    public String searchproduct(@RequestParam("searchProduct") String productname, Model model) {
        List<ProductcategoriesEntity> productCategoryEntitiyList = categoryService.findAll();
        List<ProductsEntity> Searchedproducts = productService.searchProduct(productname);
        model.addAttribute("products",Searchedproducts);
        model.addAttribute("category",productCategoryEntitiyList);
        return "searchProduct";
    }
}