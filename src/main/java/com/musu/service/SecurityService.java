package com.musu.service;

import javax.servlet.http.HttpSession;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
