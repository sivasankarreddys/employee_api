package com.sivapoc.elt.employeelt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "com.sivapoc.elt")
//@EnableJpaRepositories(basePackages = "com.sivapoc.elt.repository")
public class EmployeeLtApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeLtApplication.class, args);
    }

}
