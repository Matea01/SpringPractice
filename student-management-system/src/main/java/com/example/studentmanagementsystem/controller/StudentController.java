package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }


    //method that handles list of students and returns a model an view
    @GetMapping(value ="/students")
    public String getStudents(Model model){
    model.addAttribute("students", studentService.getAllstudents());
        return "students";
    }

    @GetMapping(value="/students/add")
    public String AddNewStudent(Model model)
    {
        //create object to hold data
        Student s= new Student();
        model.addAttribute("student",s);
        return "create-student";
    }

    @PostMapping("/students")
    public String SaveStudent(@ModelAttribute("student") Student s){
        studentService.saveStudent(s);
        return  "redirect:/students";
    }

}
