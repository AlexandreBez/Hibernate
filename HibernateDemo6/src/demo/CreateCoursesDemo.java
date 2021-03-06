package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class CreateCoursesDemo {
    
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

            Course tempCourse1 = new Course("course 1");
            Course tempCourse2 = new Course("course 2");


            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            session.save(tempCourse1);
            session.save(tempCourse2);

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
            
        }finally{

            session.close();

            factory.close();
        }
    }
}