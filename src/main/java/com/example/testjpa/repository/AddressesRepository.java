package com.example.testjpa.repository;

import com.example.testjpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Address, Integer> {

}
