package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class CreateStudentDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{

            System.out.println("Creating new Student.....please wait.......");

            Student tempStudent = new Student ("Jason", "will", "testjason@test.com");
            
            session.beginTransaction();

            System.out.println("Saving.........");
            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
        }finally{
            factory.close();
        }
    }
}