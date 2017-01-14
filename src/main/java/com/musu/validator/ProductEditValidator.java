package com.musu.validator;

import com.musu.model.ProductsEntity;
import com.musu.model.User;
import com.musu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.servlet.http.HttpSession;

@Component
public class ProductEditValidator implements Validator {
    @Autowired
    private ProductService productService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductsEntity productsEntity = (ProductsEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productcategoriesByProductCategoryId.categoryName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "NotEmpty");
        if (productsEntity.getProductName().length() < 5|| productsEntity.getProductName().length() > 32) {
            errors.rejectValue("productName", "Size.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productSku", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productPrice", "NotEmpty");
        if (productsEntity.getProductName().length() < 0) {
            errors.rejectValue("productPrice", "Size.productForm.productPrice");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productStock", "NotEmpty");
        if (productsEntity.getProductName().length() < 1|| productsEntity.getProductName().length() > 1000) {
            errors.rejectValue("productStock", "Size.productForm.productStock");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productLongDesc", "NotEmpty");
        if (productsEntity.getProductName().length() < 5|| productsEntity.getProductName().length() > 32) {
            errors.rejectValue("productLongDesc", "Size.productForm.productLongDesc");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productTags", "NotEmpty");
        if (productsEntity.getProductName().length() < 5|| productsEntity.getProductName().length() > 32) {
            errors.rejectValue("productTags", "Size.productForm.productTags");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productWeight", "NotEmpty");
        if (productsEntity.getProductName().length() < 5|| productsEntity.getProductName().length() > 32) {
            errors.rejectValue("productWeight", "Size.productForm.productStock");
        }

    }
}
