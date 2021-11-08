package com.teclab.challenge.controller;

import com.teclab.challenge.dto.CareerDTO;
import com.teclab.challenge.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/career")
public class CareerController {

    @Autowired
    private CareerService careerService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping
    public ResponseEntity<?> getAllCareer(){
        response.clear();
        response.put("careers",careerService.getAllCareer());
        response.put("timestamp", LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveCareer(@Valid @RequestBody CareerDTO careerDTO){
        careerService.saveCareer(careerDTO);
        response.clear();
        response.put("message","Career created Successfully");
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updatedCareer(@PathVariable Long id,@Valid @RequestBody CareerDTO careerDTO)
            throws Exception {
        careerService.updateCareer(id,careerDTO);
        response.clear();
        response.put("message","Career updated successfully");
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCareerById(@PathVariable Long id) throws Exception {
        response.clear();
        response.put("career",careerService.getCareerById(id));
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        careerService.deleteCareerById(id);
        response.clear();
        response.put("message","Career deleted successfully");
        response.put("timestamp", LocalDate.now());
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}