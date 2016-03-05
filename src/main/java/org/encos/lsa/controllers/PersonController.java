package org.encos.lsa.controllers;

import org.encos.lsa.dto.PersonDto;
import org.encos.lsa.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Enrico Costanzi
 */
@RestController
public class PersonController {

    private Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService personService;

    @RequestMapping("/person/{id}")
    public PersonDto getPerson(@PathVariable("id") Long id){
        log.info("Getting person with id {}", id);
        return personService.getPerson(id);

    }

    @RequestMapping("/environment")
    public String environment(){
        return personService.env();
    }


}
