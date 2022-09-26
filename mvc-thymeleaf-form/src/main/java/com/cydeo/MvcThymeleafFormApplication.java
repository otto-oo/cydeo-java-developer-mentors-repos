package com.cydeo;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MvcThymeleafFormApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MvcThymeleafFormApplication.class, args);

        DataGenerator bootStrap = context.getBean(DataGenerator.class);
        bootStrap.createUsers();
    }

}
