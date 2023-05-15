package com.example.testjpa.controller;

import com.example.testjpa.dto.WorkerInsertRequestDto;
import com.example.testjpa.model.Address;
import com.example.testjpa.model.Worker;
import com.example.testjpa.repository.AddressesRepository;
import com.example.testjpa.repository.WorkersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/workers")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class WorkersController {

    private WorkersRepository workersRepository;
    private AddressesRepository addressesRepository;

    @GetMapping(value = "/get-all")
    public List<Worker> getAll() {
        List<Worker> temp = workersRepository.findAll();

        return temp;
    }

    @GetMapping(value = "/get-all-by-address_id/{id}")
    public List<Worker> getAllByAddressId(@PathVariable int id) {
        List<Worker> temp = workersRepository.findAllByAddress_Id(id);

        return temp;
    }

    @PostMapping(value = "insert-new")
    public Worker insertNew(@RequestBody WorkerInsertRequestDto workerInsertRequestDto) {
        Address findAddress = addressesRepository.findById(workerInsertRequestDto.getAddressId()).get();

        Worker insertWorker = Worker.builder()
                .name(workerInsertRequestDto.getName())
                .address(findAddress)
                .build();

        workersRepository.save(insertWorker);

        return insertWorker;
    }

    @DeleteMapping(value = "delete-by-id/{id}")
    public void deleteById(@PathVariable int id){
        workersRepository.deleteById(id);
    }
}
