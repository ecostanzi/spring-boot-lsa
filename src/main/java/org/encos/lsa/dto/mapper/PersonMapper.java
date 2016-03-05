package org.encos.lsa.dto.mapper;

import org.encos.lsa.dto.PersonDto;
import org.encos.lsa.model.entity.Person;
import org.mapstruct.Mapper;

/**
 * @author Enrico Costanzi
 */
@Mapper(uses = AddressMapper.class)
public interface PersonMapper {

    PersonDto map(Person person);

}
