package com.narve.repository;

import com.narve.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByAddressId(int addressId);

    
}