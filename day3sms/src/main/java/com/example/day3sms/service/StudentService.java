package com.example.day3sms.service;

import com.example.day3sms.dto.StudentResponseDTO;
import com.example.day3sms.model.StudentModel;
import com.example.day3sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

//    public StudentModel add(StudentModel student) {
//        return repo.save(student);
//    }
    public StudentResponseDTO add(StudentModel dto){
        StudentModel student=new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        StudentModel saved=repo.save(student);
        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        ); 
    }

    public List<StudentModel> getAll() {
        return repo.findAll();
    }

    public StudentModel update(String id, StudentModel student) {
        student.setId(id);
        return repo.save(student);
    }

    public String delete(String id) {
        repo.deleteById(id);
        return "Student deleted successfully.";
    }
}
