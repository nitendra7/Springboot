package com.example.day3sms.service;

import com.example.day3sms.dto.StudentRequestDTO;
import com.example.day3sms.dto.StudentResponseDTO;
import com.example.day3sms.exception.StudentNotFoundException;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

//    public StudentModel add(StudentModel student) {
//        return repo.save(student);
//    }
    public StudentResponseDTO add(StudentRequestDTO student2){
        StudentModel student=new StudentModel();
        student.setName(student2.getName());
        student.setAge(student2.getAge());
        student.setEmail(student2.getEmail());
        StudentModel saved=repo.save(student);
        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        ); 
    }

    public List<StudentResponseDTO> getAllStudents() {
        return repo.findAll()
                .stream()
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getAge(),
                        student.getEmail()
                ))
                .toList();
    }

    public StudentResponseDTO update(String id, StudentRequestDTO studentRequest) {
        StudentModel student = repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());

        StudentModel saved = repo.save(student);

        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new StudentNotFoundException("Student with this ID doesn't exist.");
        }
        repo.deleteById(id);
    }

    public StudentResponseDTO partialUpdate(String id, Map<String, Object> updates) {
        StudentModel student = repo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        
        if (updates.containsKey("name")) {
            student.setName((String) updates.get("name"));
        }
        if (updates.containsKey("age")) {
            student.setAge(((Number) updates.get("age")).intValue());
        }
        if (updates.containsKey("email")) {
            student.setEmail((String) updates.get("email"));
        }
        
        StudentModel saved = repo.save(student);
        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

}
