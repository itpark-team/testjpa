package com.example.testjpa.controller2;

import com.example.testjpa.model.Address;
import com.example.testjpa.model.Address2;
import com.example.testjpa.repository.AddressesRepository;
import com.example.testjpa.repository2.Addresses2Repository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/addresses2")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class Addresses2Controller {
    private Addresses2Repository addresses2Repository;

    @GetMapping(value = "/get-all")
    public List<Address2> getAll() {
        List<Address2> temp = addresses2Repository.findAll();

        return temp;
    }

    @GetMapping(value = "/get-by-id/{id}")
    public Address2 getById(@PathVariable int id) {
        Address2 temp = addresses2Repository.findById(id).get();

        return temp;
    }
}
