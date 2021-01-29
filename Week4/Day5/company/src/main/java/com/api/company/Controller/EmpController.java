package com.api.company.Controller;


import com.api.company.Enities.Employee;
import com.api.company.Services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping(path = "/allname")
    public ResponseEntity<List<Employee>> getAllEmp(){

        List<Employee> list = empService.getAllEmp();
        if(list.size() <= 0){

            return new ResponseEntity("Not Found Any Record",HttpStatus.NOT_FOUND);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity(list,HttpStatus.OK);
//        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping
public ResponseEntity<Employee> getAllEmp(@RequestParam("id") int id,@RequestParam(value = "name",required = false) String name){
        Employee employee = empService.getEmpbyIdTitle(id,name);
        if(employee == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employee));
    }

    @PostMapping
    public Object addEmployee(@RequestBody Employee employee){

        try {
                if(employee.getEmpid() > 0) {
                    if (this.empService.addEmployee(employee) == true) {
//                        this.empService.addEmployee(employee);
                        return new ResponseEntity("Record Saved Sucessfully", HttpStatus.CREATED);

                    } else {
                        return new ResponseEntity("Please Check Name", HttpStatus.BAD_REQUEST);


                    }
                }
                else {
                    return new ResponseEntity("Id not less than 0", HttpStatus.BAD_REQUEST);

                }
            }

        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @DeleteMapping
    public ResponseEntity<String>  deleteBook(@RequestParam(value = "eid") int eid){
        String Result = "Employee Deleted Sucessfully";
        try {

            if (eid < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

            }
            else {
                this.empService.deleteEmployee(eid);
                return ResponseEntity.of(Optional.of(Result));
            }
            }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

//
//    @GetMapping
//    public String getData(@RequestParam(value = "page" , defaultValue = "1") int page,@RequestParam(value = "limit",defaultValue = "5") int limit){
//        return "Get the Page" + page + "Limit is"+limit;
//    }


}
