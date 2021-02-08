package com.companydb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emp {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empid;
    private String empname;
    private String empaddress;

    public Emp() {
        this.empid = empid;
        this.empname = empname;
        this.empaddress = empaddress;
    }

    private static List<Emp> list = new ArrayList<>();

    public static List<Emp> getList() {
        return list;
    }

    public static void setList(List<Emp> list) {
        Emp.list = list;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpaddress() {
        return empaddress;
    }

    public void setEmpaddress(String empaddress) {
        this.empaddress = empaddress;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", empaddress='" + empaddress + '\'' +
                '}';
    }






}
