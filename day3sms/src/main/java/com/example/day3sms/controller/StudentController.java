package com.example.day3sms.controller;

import com.example.day3sms.model.StudentModel;
import com.example.day3sms.dto.*;

import com.example.day3sms.repository.StudentRepository;
import com.example.day3sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;
    private final StudentRepository studentRepository;

    public StudentController(StudentService service, StudentRepository studentRepository) {
        this.service = service;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/add")
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO student) {
        return service.add(student);
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getEmail()
                )).toList();
    }

    @PutMapping("/students/{id}")
    public StudentResponseDTO updateStudent(@PathVariable String id, @Valid @RequestBody StudentRequestDTO student) {
        return service.update(id, student);
    }
    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String id) {
        service.delete(id);
    }

}
