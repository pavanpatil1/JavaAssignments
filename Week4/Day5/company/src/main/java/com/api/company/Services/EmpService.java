package com.api.company.Services;

import com.api.company.Enities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmpService {



        private static List<Employee> list = new ArrayList<>();

        static {
            list.add(new Employee(0,"Sarvesh Pathak","Plot 28,Nagar"));
            list.add(new Employee(1,"Kunal Koli","Satara,Pune"));
            list.add(new Employee(2,"Nishad patil","East Colony"));
            list.add(new Employee(3,"Shyam Pandav","Bannner,Nanded"));
        }

    public List<Employee> getAllEmp(){
            return list;
    }


    public Employee getEmpbyIdTitle(int id, String name){
        Employee employee = null;
        System.out.println("Here is Name Field"+name +"and ID"+ id);

        try{

            if(name == null ){
                for(int i=0;i<list.size();i++){
                    int p = list.get(i).getEmpid();

                    if(p == id ){
                        employee = list.get(i);
                    }

                }
            }
            else {
                for (int i = 0; i < list.size(); i++) {
                    int p = list.get(i).getEmpid();
                    String empnames = list.get(i).getEmpname();
                    if (p == id && empnames.equals(name)) {
                        employee = list.get(i);
                    }

                }
            }
//            System.out.println("Employee" + employee);


            }
        catch (Exception e){
            e.printStackTrace();
        }
        return  employee;

    }




    public Boolean addEmployee(Employee e){

        Boolean isNameValid = true;
        String username = e.getEmpname();
        for(char c: username.toCharArray()){
            if(Character.isDigit(c)){
                isNameValid = false;
            }
        }

        if(isNameValid == false ){
//            NameisnotValid();
            System.out.println("Name valid or not"+isNameValid);

        }
        else {

            list.add(e);
        }


    return isNameValid;

    }


    public void deleteEmployee(int eid){
            list.remove(eid);
    }


    public boolean NameisnotValid(){
        System.out.println("Your Name is not Valid Please Check");
        return true;
    }

//    public boolean IdisnotValid(){
//        System.out.println("ID Exist ");
//        return false;
//    }



}
