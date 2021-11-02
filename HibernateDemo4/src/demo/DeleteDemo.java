package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class DeleteDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Instructor.class)
                            .addAnnotatedClass(InstructorDetail.class)
                            .buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{            
            session.beginTransaction();

            int theId=1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            if(tempInstructor != null){
                session.delete(tempInstructor);
            }

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
        }finally{
            factory.close();
        }
    }
}