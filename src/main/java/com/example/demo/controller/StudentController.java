package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.impl.StudentServiceImpl;
import com.example.demo.util.StudentDTO;
import org.hibernate.HibernateException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/student")
public class StudentController {

    private final StudentService studentService = new StudentServiceImpl();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response creatStudentData(StudentDTO studentDTO)
    {
        Student student = new Student();
        student.setStudentName(studentDTO.getStudentName());
        student.setStudentId(studentDTO.getStudentId());
        try {
            studentService.enterStudentData(student);
        }catch (HibernateException e)
        {
            return Response.ok().entity("Details already exist!!").build();
        }
        return Response.ok().entity("Student data saved !!").build();
    }
    @PATCH
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudentData(StudentDTO studentDTO)
    {
        Student student = new Student();
        System.out.println(studentDTO.getStudentId());
        student.setId(studentService.getId(studentDTO.getStudentId()));
        student.setStudentId(studentDTO.getStudentId());
        student.setStudentName(studentDTO.getStudentName());
        try{
            studentService.updateStudentData(student);
        }catch (HibernateException e)
        {
            return Response.ok().entity("Some Error:"+ e.getMessage()).build();
        }
        return Response.ok().entity("Data is updated !!").build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudentData(StudentDTO studentDTO)
    {
        try{
            studentService.deleteStudentData(studentService.getId(studentDTO.getStudentId()));
        }catch(HibernateException e)
        {
            return  Response.ok().entity("Data not exist !!").build();
        }
        return Response.ok().entity("Data deleted ").build();
    }

    @GET
    @Path("/showAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showAllData()
    {
        List<Student> students = new ArrayList<>();

        try{
            students =studentService.getAllStudentData();
        }catch (HibernateException e)
        {
            return Response.ok().entity("No data").build();
        }
        return Response.ok().entity(students).build();
    }
}
