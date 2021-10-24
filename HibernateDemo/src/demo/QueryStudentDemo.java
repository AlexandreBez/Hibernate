package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class QueryStudentDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            //Query 
            List<Student> theStudent = session.createQuery("from Student").getResultList();

            //display

            for (Student tempStudent : theStudent) {
                System.out.println(tempStudent);
            }

            theStudent = session.createQuery("from Student s where s.lastName='Will'").getResultList();

            for (Student tempStudent : theStudent) {
                System.out.println(tempStudent);
            }

            theStudent = session.createQuery("from Student s where s.lastName='Will' or s.firstName='willian'").getResultList();

            for (Student tempStudent : theStudent) {
                System.out.println(tempStudent);
            }

            theStudent = session.createQuery("from Student s where s.email LIKE '%test%'").getResultList();

            for (Student tempStudent : theStudent) {
                System.out.println(tempStudent);
            }

            System.out.println("Saving.........");
            
            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
        }finally{
            factory.close();
        }
    }
}