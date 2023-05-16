package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllstudents();
    Student saveStudent(Student s);
}
