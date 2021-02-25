package com.example.Controller;

import com.example.Services.Pservice;
import com.example.dao.userRepository;
import com.example.enitites.Patientdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    @Autowired
    private userRepository userRepository;


    @GetMapping(path = "/alldata")
    public ResponseEntity<List<Patientdata>> getPatient(){

        List<Patientdata> list = userRepository.findAll();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }


    @PostMapping(path = "/store")
    public ResponseEntity<String> addPatientData(@RequestBody Patientdata patientdata){
        try {
                this.userRepository.save(patientdata);
                return new ResponseEntity("Record Saved Sucessfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }






}
