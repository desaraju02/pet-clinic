package com.nag.repositories;

import com.nag.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Owner findByLastName(String lastName);

}
