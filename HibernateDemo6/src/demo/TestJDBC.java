package demo;

import java.sql.Connection;
import java.sql.DriverManager;

public interface TestJDBC {
    
    public static void main(String[] args) {
        
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "admin";
        String pass = "admin";

        try{
            System.out.println("Connecting to database: " + jdbcURL);

            Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);

            System.out.println("sucefull");
        }
        catch(Exception exc){
            exc.printStackTrace();
        }

    }
}