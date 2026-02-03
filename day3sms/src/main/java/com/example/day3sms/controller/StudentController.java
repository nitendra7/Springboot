package com.example.day3sms.controller;

import com.example.day3sms.model.StudentModel;
import com.example.day3sms.dto.*;

import com.example.day3sms.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public StudentResponseDTO addStudent(@RequestBody StudentModel student) {
        return service.add(student);
    }

    @GetMapping("/students")
    public List<StudentModel> getAllStudents() {
        return service.getAll();
    }

    @PutMapping("/students/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
        return service.update(id, student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable String id) {
        return service.delete(id);
    }
}
