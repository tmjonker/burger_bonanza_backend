package com.tmjonker.burgerbonanza.repositories;

import com.tmjonker.burgerbonanza.entities.address.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
