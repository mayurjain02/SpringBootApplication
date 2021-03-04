package com.example.demo.service.impl;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public void enterStudentData(Student student) {
        studentDAO.enterStudentData(student);
    }

    @Override
    public List<Student> getAllStudentData() {
        return studentDAO.getAllStudentData();
    }

    @Override
    public void updateStudentData(Student student) {
        studentDAO.updateStudentData(student);
    }

    @Override
    public Integer getId(String studentId) {
        return studentDAO.getId(studentId);
    }

    @Override
    public void deleteStudentData(Integer id) {
            studentDAO.deleteStudentData(id);
    }
}
