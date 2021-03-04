package com.example.demo.dao;

import com.example.demo.bean.Student;
import com.example.demo.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void enterStudentData(Student student)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
    }

    public List<Student> getAllStudentData()
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> data = new ArrayList<>();
        String hql = "From Student s";
        Query query = session.createQuery(hql);
        data = (List<Student>) query.getResultList();
        transaction.commit();
        session.close();
        return data;
    }

    public void updateStudentData(Student student)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction =  session.beginTransaction();

        String hql = "Update Student s SET s.studentName=:givenName, s.studentId=:givenStudentId where s.id=:givenId";
        Query query = session.createQuery(hql);
        query.setParameter("givenName",student.getStudentName());
        query.setParameter("givenStudentId",student.getStudentId());
        query.setParameter("givenId",student.getId());
        int row = query.executeUpdate();

        transaction.commit();
        session.close();

    }

    public Integer getId(String studentId)
    {
        Session session = SessionUtil.getSession();
        Transaction  transaction= session.beginTransaction();

        String hql = "select s.id From Student s where s.studentId=:givenStudentId";
        Query query = session.createQuery(hql);
        query.setParameter("givenStudentId",studentId);
        Integer id =(Integer) query.getResultList().get(0);
        transaction.commit();
        session.close();
        return id;
    }
    public void deleteStudentData(Integer id)
    {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        String hql ="Delete from Student s where s.id = :givenId";
        Query query= session.createQuery(hql);
        query.setParameter("givenId",id);
        int row= query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
