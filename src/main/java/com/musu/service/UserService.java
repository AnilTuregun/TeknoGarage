package com.musu.service;

import com.musu.model.User;
import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findByUsername(String username);
    void deleteUser(int id);
}
