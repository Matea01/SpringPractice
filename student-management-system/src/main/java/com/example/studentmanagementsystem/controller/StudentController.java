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

    @GetMapping("students/edit/{id}")
    public String editStudents (@PathVariable Long id, Model m)
    {
        m.addAttribute("student",studentService.getStudentById(id));
        return "edit";
    }

    @PostMapping("students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model m){
        //get student from database
        Student existing= studentService.getStudentById(id);
        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        //save the changes
        studentService.update(existing);
        return "redirect:/students";
    }


}
