package com.example.dao;

import com.example.enitites.Patientdata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<Patientdata, Integer> {

    public List<Patientdata> findBypname(String pname);

    @Override
    List<Patientdata> findAll();

}
