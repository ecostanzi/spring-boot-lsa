package org.encos.lsa.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Enrico Costanzi
 */
public class PersonDto {

    @Getter @Setter Long id;
    @Getter @Setter String firstName;
    @Getter @Setter String lastName;
}
