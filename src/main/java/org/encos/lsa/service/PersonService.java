package org.encos.lsa.service;

import org.encos.lsa.dto.PersonDto;
import org.encos.lsa.exceptions.NotFoundException;
import org.encos.lsa.model.entity.Person;
import org.encos.lsa.model.repository.PersonRepository;
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
