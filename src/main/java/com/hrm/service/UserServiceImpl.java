package com.hrm.service;

import com.hrm.mapper.UserMapper;
import com.hrm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiuSitong on 2017/6/22.
 */

@Service
public class UserServiceImpl {
    @Autowired
    private  UserMapper uDao;

    public User selectByLoginname(String loginname,String password ){
        User u = uDao.selectByLoginname(loginname,password);
        return  u;
    }

}
