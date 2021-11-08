package com.teclab.challenge.controller;

import com.teclab.challenge.dto.PupilDTO;
import com.teclab.challenge.service.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pupils")
public class PupilController {

    @Autowired
    private PupilService pupilService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping
    public ResponseEntity<?> getAllPupils(){
        response.clear();
        response.put("pupils",pupilService.getAllPupil());
        response.put("timestamp", LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savePupil(@Valid @RequestBody PupilDTO pupilDTO){
        response.clear();
        response.put("message","Pupil created successfully");
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        pupilService.deletePupil(id);
        response.clear();
        response.put("message","Pupil deleted successfully");
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        response.clear();
        response.put("pupil",pupilService.getPupil(id));
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}