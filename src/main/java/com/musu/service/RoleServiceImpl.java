package com.musu.service;

import com.musu.model.ProductcategoriesEntity;
import com.musu.model.Role;
import com.musu.repository.ProductcategoriesRepository;
import com.musu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
@Autowired
private RoleRepository roleRepository;
    @Override
    public void save(Role role) {

    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
