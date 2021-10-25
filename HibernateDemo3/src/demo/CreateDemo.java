package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class CreateDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Instructor.class)
                            .addAnnotatedClass(InstructorDetail.class)
                            .buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{

            Instructor tempInstructor = new Instructor("chad", "Darby", "test@test.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("channel1", "hobby1");
            
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
        }finally{
            factory.close();
        }
    }
}