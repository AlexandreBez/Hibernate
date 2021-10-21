package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class PrimaryKeyDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{

            System.out.println("Creating new Student.....please wait.......");

            Student tempStudent1 = new Student ("Willian", "Blake", "testBlake@test.com");
            Student tempStudent2 = new Student ("Mary", "Layne", "testLayne@test.com");
            Student tempStudent3 = new Student ("James", "Smith", "testSmith@test.com");

            session.beginTransaction();

            System.out.println("Saving.........");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            System.out.println("Sucess!!!!");
        }finally{
            factory.close();
        }
    }
}