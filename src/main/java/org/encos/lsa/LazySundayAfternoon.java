package org.encos.lsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author Enrico Costanzi
 */
@SpringBootApplication
public class LazySundayAfternoon extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LazySundayAfternoon.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(LazySundayAfternoon.class, args);
    }
}
