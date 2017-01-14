package com.musu.validator;

import com.musu.model.ProductsEntity;
import com.musu.model.User;
import com.musu.service.ProductService;
import com.musu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {
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
        if (productService.findBySkuNumber(productsEntity.getProductSku()) != null) {

            errors.rejectValue("productSku", "Duplicate.productForm.productSku");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productPrice", "NotEmpty");
        if (productsEntity.getProductPrice() < 0) {
            errors.rejectValue("productPrice", "Size.productForm.productPrice");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productStock", "NotEmpty");
        if (productsEntity.getProductStock() < 1|| productsEntity.getProductStock()> 1000) {
            errors.rejectValue("productStock", "Size.productForm.productStock");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productLongDesc", "NotEmpty");
        if (productsEntity.getProductLongDesc().length() < 5|| productsEntity.getProductLongDesc().length() > 255) {
            errors.rejectValue("productLongDesc", "Size.productForm.productLongDesc");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productTags", "NotEmpty");
        if (productsEntity.getProductTags().length()< 5|| productsEntity.getProductTags().length() > 255) {
            errors.rejectValue("productTags", "Size.productForm.productTags");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productWeight", "NotEmpty");
        if (productsEntity.getProductWeight() <0) {
            errors.rejectValue("productWeight", "Size.productForm.productStock");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productImage", "NotEmpty");
    }
}
