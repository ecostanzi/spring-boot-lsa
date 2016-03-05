package org.encos.lsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Enrico Costanzi
 */
@SpringBootApplication
public class LazySundayAfternoon extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        Map<String, Object> map = new HashMap<>();
        map.put("spring.config.location", "classpath:lsa/");
        return application.properties(map).sources(LazySundayAfternoon.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(LazySundayAfternoon.class, args);
    }
}
