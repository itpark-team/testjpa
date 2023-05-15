package com.example.testjpa.repository;

import com.example.testjpa.model.Address;
import com.example.testjpa.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkersRepository extends JpaRepository<Worker, Integer> {
    List<Worker> findAllByAddress_Id(int id);
}
