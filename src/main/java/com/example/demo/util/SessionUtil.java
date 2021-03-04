package com.example.demo.util;

import com.example.demo.bean.Student;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

    private static SessionFactory sessionFactory;

    static {
        try{
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Student.class);
            sessionFactory = configuration.buildSessionFactory();
        }catch(HibernateException e)
        {
            throw new HibernateException(e);
        }
    }

    public static org.hibernate.Session getSession() throws HibernateException
    {
        return sessionFactory.openSession();
    }
}
