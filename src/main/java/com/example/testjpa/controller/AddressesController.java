package com.example.testjpa.controller;

import com.example.testjpa.model.Address;
import com.example.testjpa.model.Worker;
import com.example.testjpa.repository.AddressesRepository;
import com.example.testjpa.repository.WorkersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/addresses")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class AddressesController {
    private AddressesRepository addressesRepository;

    @GetMapping(value = "/get-all")
    public List<Address> getAll() {
        List<Address> temp = addressesRepository.findAll();

        return temp;
    }

    @GetMapping(value = "/get-by-id/{id}")
    public Address getById(@PathVariable int id) {
        Address temp = addressesRepository.findById(id).get();

        return temp;
    }

    @DeleteMapping(value = "delete-by-id/{id}")
    public void deleteById(@PathVariable int id){
        addressesRepository.deleteById(id);
    }
}
