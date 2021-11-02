package demo;

import org.checkerframework.checker.units.qual.s;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class GetInstructorCoursesDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Instructor.class)
                            .addAnnotatedClass(InstructorDetail.class)
                            .addAnnotatedClass(Course.class)
                            .buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println(tempInstructor +" "+ tempInstructor.getCourses());

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
            
        }finally{

            session.close();

            factory.close();
        }
    }
}