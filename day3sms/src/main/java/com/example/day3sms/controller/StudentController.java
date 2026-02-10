package com.example.day3sms.controller;

import com.example.day3sms.model.StudentModel;
import com.example.day3sms.dto.*;

import com.example.day3sms.repository.StudentRepository;
import com.example.day3sms.service.StudentService;
import com.example.day3sms.util.JwtUtil;
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
    //private final StudentRepository studentRepository;
    private final JwtUtil jwtUtil;

    public StudentController(StudentService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    private void checkToken(String authHeader){
        if (authHeader==null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Invalid Token");
        }
        String token=authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }

    @GetMapping("/students")
    public String getStudentsPage() {
        return "students"; // This maps to students.html in the templates folder
    }

    // API Endpoints
    @GetMapping("/api/students")
    @ResponseBody
    public List<StudentResponseDTO> getAllStudents(
            @RequestHeader("Authorization") String authHeader) {
        checkToken(authHeader);
        return service.getAllStudents();
    }

    @PostMapping("/add")
    @ResponseBody
    public StudentResponseDTO addStudent(
            @RequestHeader(value = "Authorization",required = false) String authHeader,
            @Valid @RequestBody StudentRequestDTO student) {
        checkToken(authHeader);
        return service.add(student);
    }

    @PutMapping("/students/{id}")
    @ResponseBody
    public StudentResponseDTO updateStudent(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id, 
            @Valid @RequestBody StudentRequestDTO student) {
        checkToken(authHeader);
        return service.update(id, student);
    }

    @PatchMapping("/students/{id}")
    @ResponseBody
    public StudentResponseDTO partialUpdateStudent(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id, 
            @RequestBody Map<String, Object> updates) {
        checkToken(authHeader);
        return service.partialUpdate(id, updates);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable String id) {
        checkToken(authHeader);
        service.delete(id);
    }

}
