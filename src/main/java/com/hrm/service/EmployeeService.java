package com.hrm.service;

import com.hrm.mapper.EmployeeMapper;
import com.hrm.model.Employee;
import com.hrm.model.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiuSitong on 2017/6/22.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper eDao;


    /**
     *
     * @return  查询所有员工信息
     */
    public List<Employee> selectByExample(){
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andIdIsNotNull();
        return eDao.selectByExample(example);
    }

}
