package com.musu.service;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);

    List<Role> findAll();
      Role findRoleByName(String name);
}
