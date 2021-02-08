package com.companydb.Services;

import com.companydb.dao.UserRepository;
import com.companydb.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpService {


    @Autowired
    UserRepository userRepository;


    private Emp emp;

    public List<Emp> getAllEmp(){
        return emp.getList();
    }



}
