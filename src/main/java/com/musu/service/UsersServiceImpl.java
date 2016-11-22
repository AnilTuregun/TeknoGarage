package com.musu.service;

import com.musu.model.UsersEntity;
import com.musu.repository.RoleRepository;
import com.musu.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UsersEntity user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));

        usersRepository.save(user);
    }

}
