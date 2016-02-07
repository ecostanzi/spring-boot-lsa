package org.booty.service;

import org.booty.dto.PersonDto;
import org.booty.exceptions.NotFoundException;
import org.booty.model.entity.Person;
import org.booty.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Enrico Costanzi
 */
@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonDto getPerson(Long id){
        //todo map using orika or something like that

        Person personEntity = personRepository.findOne(id);

        if(personEntity == null){
            throw new NotFoundException(String.format("Person with id %d not found", id));
        }

        PersonDto personDto = new PersonDto();
        personDto.setId(personEntity.getId());
        personDto.setFirstName(personEntity.getFirstName());
        personDto.setLastName(personEntity.getLastName());

        return personDto;
    }
}
