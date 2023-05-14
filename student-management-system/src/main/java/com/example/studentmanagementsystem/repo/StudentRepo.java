package com.example.studentmanagementsystem.repo;

import com.example.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//Nema potrebe stavljati anotaciju @Repository jer je JpaRepo podtip SimpleRepo koji je sam
//po sebi @Repository
//kad kliknes desni kliok na JpaRepo-> go to-> implementation-> SimpleRepo
public interface StudentRepo extends JpaRepository<Student, Long> {

}

