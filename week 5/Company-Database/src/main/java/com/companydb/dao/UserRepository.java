package com.companydb.dao;


import com.companydb.entities.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Emp , Integer> {


    public List<Emp> findByempname(String empname);

    @Override
    List<Emp> findAll();


}
