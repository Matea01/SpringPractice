package com.example.studentmanagementsystem.Impl;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.repo.StudentRepo;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public List<Student> getAllstudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student s) {
        return studentRepo.save(s);
    }

    @Override
    public Student editStudent(Student s) {
        return studentRepo.save(s);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();//get je rijesilo problem
    }

    @Override
    public Student update(Student s) {
        return studentRepo.save(s);
    }
}
