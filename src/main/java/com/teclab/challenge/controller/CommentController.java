package com.teclab.challenge.controller;

import com.teclab.challenge.dto.CommentDTO;
import com.teclab.challenge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping
    public ResponseEntity<?> getAllComments(){
        response.clear();
        response.put("comments",commentService.getAllComments());
        response.put("timestamp", LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveComment(@Valid @RequestBody CommentDTO commentDTO){
        response.clear();
        response.put("comment",commentDTO);
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable Long id){
        response.clear();;
        response.put("comment",commentService.getCommentById(id));
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        response.clear();
        response.put("message","Comment deleted");
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id,@Valid @RequestBody CommentDTO commentDTO){
        response.clear();
        response.put("message","Comment updated");
        response.put("timestamp",LocalDate.now());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
