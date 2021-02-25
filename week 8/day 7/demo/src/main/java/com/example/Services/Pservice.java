package com.example.Services;

import com.example.dao.userRepository;
import com.example.enitites.Patientdata;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Pservice {

    @Autowired
    userRepository userRepository;

    private Patientdata patientdata;

    public List<Patientdata> getAllEmp(){
        return patientdata.getList();
    }
}
