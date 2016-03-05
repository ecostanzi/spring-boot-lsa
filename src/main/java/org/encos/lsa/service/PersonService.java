package org.encos.lsa.service;

import org.encos.lsa.dto.PersonDto;
import org.encos.lsa.dto.mapper.PersonMapper;
import org.encos.lsa.exceptions.NotFoundException;
import org.encos.lsa.model.entity.Address;
import org.encos.lsa.model.entity.City;
import org.encos.lsa.model.entity.District;
import org.encos.lsa.model.entity.Person;
import org.encos.lsa.model.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Enrico Costanzi
 */
@Service
public class PersonService {

    private Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    @Value("${lsa.environment.name}")
    String environment;

    public PersonDto getPerson(Long id){

        if(id % 2 == 0){
            //fixme use a script to put data into the h2 database
            log.info("Returing fake person with id {}", id);

            Person person = new Person();
            person.setFirstName("Enrico");
            person.setLastName("Costanzi");
            person.setId(id);

            City city = new City();
            city.setId(0L);
            city.setName("Verona");

            District district = new District();
            district.setId(5L);
            district.setName("Veneto");

            Address address = new Address();
            address.setStreetName("Piazza Bra");
            address.setStreetNumber("1");
            address.setZipCode("37100");
            address.setCity(city);
            address.setDistrict(district);

            person.setAddress(address);


            if(id>=10){
                return personMapper.mapNoAddress(person);
            }
            return personMapper.map(person);
        }

        Person personEntity = personRepository.findOne(id);

        if(personEntity == null){
            log.warn("Person not found");
            throw new NotFoundException(String.format("Person with id %d not found", id));
        }

        return personMapper.map(personEntity);
    }

    public String env(){
        return environment;
    }
}
