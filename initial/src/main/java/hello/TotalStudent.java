package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;






public class TotalStudent {


 public static void TotalStudent() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {



        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connect= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springboot", "root", "");

        Statement stat = connect.createStatement();

        stat = connect.createStatement();
        ResultSet result = stat
                .executeQuery("  SELECT Instructor_Name ,SUM(Student_Capa)from schedule GROUP BY Instructor_Name");

        System.out.println("\n\n THE NUMBER OF STUDENTS FOR EACH INSTRUCTOR \n\n");
        while (result.next()) {
            String InstructorName  = result.getString(1);
            int total = result.getInt(2);

            System.out.println("Instructor_Name : " + InstructorName + ",  The number of students: " + total);




        }


        result.close();
        stat.close();
        connect.close();



    }





}




