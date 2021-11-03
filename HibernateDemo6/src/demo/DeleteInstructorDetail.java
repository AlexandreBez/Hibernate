package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class DeleteInstructorDetail {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Instructor.class)
                            .addAnnotatedClass(InstructorDetail.class)
                            .buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{            
            session.beginTransaction();

            int theId=3;

            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            System.out.println(tempInstructorDetail);

            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempInstructorDetail);

            session.getTransaction().commit();
            System.out.println("Sucess!!!!");
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            session.close();

            factory.close();
        }
    }
}