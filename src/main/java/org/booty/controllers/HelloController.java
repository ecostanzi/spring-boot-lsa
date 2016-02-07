package org.booty.controllers;

import org.booty.BootyException;
import org.booty.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "Greetings from Spring Boot!!";
    }

    @RequestMapping("/person/{id}")
    public PersonDto getPerson(@PathVariable("id") Long id){
        if(id == 0){
            throw new BootyException("No person with id 0");
        }
        PersonDto personDto = new PersonDto();
        personDto.setFirstName("Enrico");
        personDto.setLastName("Costanzi");
        personDto.setId(id);

        return personDto;
    }


}
