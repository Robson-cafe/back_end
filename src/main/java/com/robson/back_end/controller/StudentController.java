package com.robson.back_end.controller;

import com.robson.back_end.dto.StudentRequestDTO;
import com.robson.back_end.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody StudentRequestDTO studentRequestDTO) {
        return studentService.save(studentRequestDTO);
    }

}
