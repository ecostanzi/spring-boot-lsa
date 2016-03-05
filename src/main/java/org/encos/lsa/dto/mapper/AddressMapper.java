package org.encos.lsa.dto.mapper;

import org.encos.lsa.dto.AddressDto;
import org.encos.lsa.model.entity.Address;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author Enrico Costanzi
 */
@Mapper
@DecoratedWith(AddressMapperDecorator.class)
public interface AddressMapper {

    @Mappings({
            @Mapping(target = "street", ignore = true),
            @Mapping(target = "zip", source = "zipCode"),
            @Mapping(target = "district", source = "district.name"),
            @Mapping(target = "city", source = "city.name"),
    })
    AddressDto map(Address address);

}
