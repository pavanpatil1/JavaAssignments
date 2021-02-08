package com.companydb.Controller;


import com.companydb.Services.EmpService;
import com.companydb.dao.UserRepository;
import com.companydb.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    EmpService empService;

    @GetMapping(path = "/allEmp")
    public ResponseEntity<List<Emp>> getAllEmp(){

        List<Emp> list = userRepository.findAll();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }


    @GetMapping
    public ResponseEntity<Optional<Emp>> getEmp(@RequestParam(value = "id") int id){

        Optional<Emp> emps = userRepository.findById(id);

        if(emps.isPresent()){
            System.out.println("presnt");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(emps));

    }


    @GetMapping(path = "name")
    public List<Emp> getEmp(@RequestParam(value = "empname") String empname){

        return (List<Emp>) userRepository.findByempname(empname);

    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Emp emp){

        try {
                if(isNameCorrecrt(emp) == false ){
                    return new ResponseEntity("Please Check Name", HttpStatus.BAD_REQUEST);
                }
                else {
                    this.userRepository.save(emp);
                    return new ResponseEntity("Record Saved Sucessfully", HttpStatus.CREATED);
                }

        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }



    @DeleteMapping
    public ResponseEntity<String> deleteEmp(@RequestParam(value = "id") int id) {
        Optional<Emp> empOptional = userRepository.findById(id);
        String Result = "Employee Deleted Sucessfully";


                if (empOptional.isPresent()) {
                    userRepository.delete(empOptional.get());
                    return ResponseEntity.of(Optional.of(Result));
                }
                else {
                    return new ResponseEntity("Wrong Id Please Check", HttpStatus.NOT_FOUND);

                }

        }


        @PutMapping
        public ResponseEntity<String> update(@RequestBody Emp empobj){

            String b = "Employee Updated Sucessfully";
            try {
               Emp exsitingEmp = userRepository.findById(empobj.getEmpid()).orElse(null);
               if(empobj.getEmpid() == 0){
                   return new ResponseEntity("Please Provide ID", HttpStatus.BAD_REQUEST);
               }
               else {
                   exsitingEmp.setEmpid(empobj.getEmpid());
               }

                if(isNameCorrecrt(empobj) == false ){
                    return new ResponseEntity("Please Check Name", HttpStatus.BAD_REQUEST);

                }

                else {
                    exsitingEmp.setEmpname(empobj.getEmpname());
                }

               exsitingEmp.setEmpaddress(empobj.getEmpaddress());
               userRepository.save(exsitingEmp);
               return ResponseEntity.of(Optional.of(b));

            }
            catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity("Wrong Id Please Check", HttpStatus.NOT_FOUND);

            }

        }



       public Boolean isNameCorrecrt(Emp emp){

           Boolean isNameValid = true;
           String username = emp.getEmpname();
           for(char c: username.toCharArray()){
               if(Character.isDigit(c)){
                   isNameValid = false;
               }
           }

           if(isNameValid == false ){


               return false;
           }
           else {
               return true;
           }

       }

}
