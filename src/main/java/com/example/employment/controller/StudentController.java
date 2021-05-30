package com.example.employment.controller;

import com.example.employment.dto.StudentRequestDTO;
import com.example.employment.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody StudentRequestDTO studentRequest){
        studentService.add(studentRequest);
        }



}
