package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }


    //method that handles list of students and returns a model an view
    @RequestMapping(value ="/students")
    public String students(Model model){
    model.addAttribute("students", studentService.getAllstudents());
        return "students";
    }

}
