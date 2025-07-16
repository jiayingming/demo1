package com.dianxing.service.impl;

import com.dianxing.mapper.LoginMapper;
import com.dianxing.pojo.User;
import com.dianxing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User login(User user) {
        return loginMapper.findByUsernameAndPassword(
                user.getUsername(),
                user.getPassword()
        );
    }
}