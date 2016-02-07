package org.booty.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Enrico Costanzi
 */
@RestController
public class HelloController {

    private Logger log = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/")
    public String greetings() {
        log.info("Saying hello to my user!");
        return "Greetings from Spring Boot!";
    }
}
