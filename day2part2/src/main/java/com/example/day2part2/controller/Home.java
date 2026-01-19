package com.example.day2part2.controller;

import com.example.day2part2.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Home {
    @GetMapping("/")
    public ArrayList<StudentModel> getStudents(){
        ArrayList<StudentModel> students=new ArrayList<>();
        students.add(new StudentModel(1,"nish","abc1@xyz.com"));
        students.add(new StudentModel(2,"chitrang","abc2@xyz.com"));
        students.add(new StudentModel(3,"nitendra","abc3@xyz.com"));
        students.add(new StudentModel(4,"dev","abc4@xyz.com"));
        students.add(new StudentModel(5,"joginder","abc5@xyz.com"));

        return students;
    }
}
