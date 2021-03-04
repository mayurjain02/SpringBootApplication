package com.example.demo.service;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDAO;

import java.util.List;

public interface StudentService {

    StudentDAO studentDAO= new StudentDAO();

    void enterStudentData(Student student);
    List<Student> getAllStudentData();
    void updateStudentData(Student student);
    Integer getId(String studentId);
    void deleteStudentData(Integer id);

}
