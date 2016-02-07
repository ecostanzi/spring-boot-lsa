package org.encos.lsa.controllers;

import org.encos.lsa.dto.PersonDto;
import org.encos.lsa.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(id == 0){
            PersonDto personDto = new PersonDto();
            personDto.setFirstName("Enrico");
            personDto.setLastName("Costanzi");
            personDto.setId(id);

            return personDto;
        }

        return personService.getPerson(id);

    }


}
