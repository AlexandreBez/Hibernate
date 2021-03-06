package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class DeleteStudentDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{
            
            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGet student wih id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Deleting................");
            session.delete(myStudent);

            session.createQuery("delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
        
        }finally{
            factory.close();
        }
    }
}