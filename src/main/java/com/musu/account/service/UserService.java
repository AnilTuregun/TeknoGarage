package com.musu.account.service;

import com.musu.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
