package com.example.day3sms.controller;

import com.example.day3sms.model.StudentModel;
import com.example.day3sms.dto.*;

import com.example.day3sms.repository.StudentRepository;
import com.example.day3sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins="*")
public class StudentController {

    private final StudentService service;
    private final StudentRepository studentRepository;

    public StudentController(StudentService service, StudentRepository studentRepository) {
        this.service = service;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String getStudentsPage() {
        return "students"; // This maps to students.html in the templates folder
    }

    // API Endpoints
    @GetMapping("/api/students")
    @ResponseBody
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

    @PostMapping("/add")
    @ResponseBody
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO student) {
        return service.add(student);
    }

    @PutMapping("/students/{id}")
    @ResponseBody
    public StudentResponseDTO updateStudent(@PathVariable String id, @Valid @RequestBody StudentRequestDTO student) {
        return service.update(id, student);
    }

    @PatchMapping("/students/{id}")
    @ResponseBody
    public StudentResponseDTO partialUpdateStudent(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        return service.partialUpdate(id, updates);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String id) {
        service.delete(id);
    }

}
