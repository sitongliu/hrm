package com.hrm.controller;

import com.hrm.model.User;
import com.hrm.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LiuSitong on 2017/6/22.
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User u){
        User user = userService.selectByLoginname(u.getLoginname(),u.getPassword());
        if (user!=null){
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }else {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
    }

}
