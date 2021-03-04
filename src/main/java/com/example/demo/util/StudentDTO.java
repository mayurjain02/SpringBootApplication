package com.example.demo.util;

public class StudentDTO {

    private String studentName;
    private String studentId;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                ", studentName='" + studentName + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
