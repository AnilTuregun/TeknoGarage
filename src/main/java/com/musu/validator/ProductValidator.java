package com.musu.validator;

import com.musu.model.ProductsEntity;
import com.musu.model.User;
import com.musu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductsEntity productsEntity = (ProductsEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "NotEmpty");
        if (productsEntity.getProductName().length() < 5|| productsEntity.getProductName().length() > 32) {
            errors.rejectValue("productName", "Size.userForm.username");
        }

    }
}
