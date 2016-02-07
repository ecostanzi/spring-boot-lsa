package org.booty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.ServletContextApplicationContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import javax.servlet.ServletContext;

/**
 * @author Enrico Costanzi
 */
@SpringBootApplication
public class Booty extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Booty.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Booty.class, args);
    }
}
