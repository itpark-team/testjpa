package com.example.testjpa.controller2;

import com.example.testjpa.dto.WorkerInsertRequestDto;
import com.example.testjpa.model.Address;
import com.example.testjpa.model.Worker;
import com.example.testjpa.model.Worker2;
import com.example.testjpa.repository.AddressesRepository;
import com.example.testjpa.repository.WorkersRepository;
import com.example.testjpa.repository2.Workers2Repository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/workers2")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class Workers2Controller {

    private Workers2Repository workers2Repository;

    @GetMapping(value = "/get-all")
    public List<Worker2> getAll() {
        List<Worker2> temp = workers2Repository.findAll();
        return temp;
    }
}
