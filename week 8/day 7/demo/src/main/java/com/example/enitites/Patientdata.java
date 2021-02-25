package com.example.enitites;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patientdata")
public class Patientdata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;
        private String pname;
        private String pmob;
        private String bdate;


    private static List<Patientdata> list = new ArrayList<>();

    public static List<Patientdata> getList() {
        return list;
    }

    public static void setList(List<Patientdata> list) {
        Patientdata.list = list;
    }

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPmob() {
        return pmob;
    }

    public void setPmob(String pmob) {
        this.pmob = pmob;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    @Override
    public String toString() {
        return "Patientdata{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pmob='" + pmob + '\'' +
                ", bdate='" + bdate + '\'' +
                '}';
    }
}

