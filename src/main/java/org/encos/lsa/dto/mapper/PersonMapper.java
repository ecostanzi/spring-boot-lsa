package org.encos.lsa.dto.mapper;

import org.encos.lsa.dto.PersonDto;
import org.encos.lsa.model.entity.Person;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Enrico Costanzi
 */
@Mapper(uses = AddressMapper.class)
public interface PersonMapper {

    @Mapping(target = "name", source = "firstName")
    PersonDto map(Person person);

    @InheritConfiguration
    @Mapping(target = "address", ignore = true)
    PersonDto mapNoAddress(Person address);

}
