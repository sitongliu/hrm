package com.hrm.controller;

import com.hrm.model.Employee;
import com.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LiuSitong on 2017/6/22.
 */
@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeContrller {

    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> selectAllEmployee(){

        List<Employee> list = employeeService.selectByExample();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
