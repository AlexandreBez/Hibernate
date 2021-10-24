package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class ReadStudentDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{

            System.out.println("Creating new Student.....please wait.......");

            Student tempStudent = new Student ("Willian", "Blake", "testBlake@test.com");

            session.beginTransaction();

            System.out.println("Saving.........");
            System.out.println(tempStudent);
            session.save(tempStudent);

            session.getTransaction().commit();

            System.out.println("Saved student: Generated id: " + tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
        }finally{
            factory.close();
        }
    }
}