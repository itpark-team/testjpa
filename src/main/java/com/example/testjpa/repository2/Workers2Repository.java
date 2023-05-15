package com.example.testjpa.repository2;

import com.example.testjpa.model.Worker;
import com.example.testjpa.model.Worker2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Workers2Repository extends JpaRepository<Worker2, Integer> {
}
