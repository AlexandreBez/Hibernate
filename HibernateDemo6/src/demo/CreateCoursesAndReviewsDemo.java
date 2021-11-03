package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;

public class CreateCoursesAndReviewsDemo {
    
    public static void main(String[] args) {
        
        SessionFactory factory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Instructor.class)
                            .addAnnotatedClass(InstructorDetail.class)
                            .addAnnotatedClass(Course.class)
                            .addAnnotatedClass(Review.class)
                            .buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            Course tempCourse = new Course("Course 1");
            
            tempCourse.addReview(new Review("Great Course1!!!!"));
            tempCourse.addReview(new Review("Great Course2!!!!"));
            tempCourse.addReview(new Review("Great Course3!!!!"));
            tempCourse.addReview(new Review("Great Course4!!!!"));
            tempCourse.addReview(new Review("Great Course5!!!!"));
            tempCourse.addReview(new Review("Great Course6!!!!"));

            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);

            session.getTransaction().commit();

            System.out.println("Sucess!!!!");
            
        }finally{

            session.close();

            factory.close();
        }
    }
}