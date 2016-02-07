package org.encos.lsa.model.repository;

import org.encos.lsa.model.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by stevenheyninck on 29/10/15.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
}
