package com.example.testjpa.repository2;

import com.example.testjpa.model.Address;
import com.example.testjpa.model.Address2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Addresses2Repository extends JpaRepository<Address2, Integer> {
}
