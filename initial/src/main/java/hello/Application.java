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
import sun.plugin2.message.Message;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {



            System.out.println("0- For Exit");
            System.out.println("1- springboot Project");
            System.out.println("2- Total Student pear Instructor Name");
            System.out.println("3- QueryTest");
            System.out.println("4- ScrapyFall20016");

            try {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine();
                int userInput = Integer.parseInt(br.readLine());

                if (userInput >= 0 && userInput <= 4) {

                    if (userInput == 0) {
                        System.exit(0);
                    }

                    if (userInput == 1) {
                        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
                    }

                    if (userInput == 2) {

                       // ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
                        TotalStudent show = new TotalStudent();
                        show.TotalStudent();
                    }


                    if (userInput == 3) {

                       // ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
                        QueryTest query = new QueryTest();
                        query.Message();
                    }


                    if (userInput == 4) {

                       // ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
                        ScrapyFall2016 scrapy = new ScrapyFall2016();
                        scrapy.scrapyfall2016();

                    }
                } else
                {
                    System.out.println("Please Select right Number from 0 - 4 ");
                    main(null);

                }


            } catch (NumberFormatException e) {
                System.out.println("Please Select right Number from 0 - 4 ");
            }


    }
}