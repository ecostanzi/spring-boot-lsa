package org.encos.lsa.dto.mapper;

import org.encos.lsa.dto.AddressDto;
import org.encos.lsa.model.entity.Address;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Enrico Costanzi
 */
@Mapper
public abstract class AddressMapperDecorator implements AddressMapper{

    @Autowired
    @Qualifier("delegate")
    private AddressMapper delegate;

    @Override
    public AddressDto map(Address address) {
        AddressDto dto = delegate.map( address );
        dto.setStreet(address.getStreetName() + ", " + address.getStreetNumber());
        return dto;
    }

}
