package com.example.testjpa.controller;

import com.example.testjpa.dto.AddressXResponseDto;
import com.example.testjpa.dto.WorkerXResponseDto;
import com.example.testjpa.model.Address;
import com.example.testjpa.model.Worker;
import com.example.testjpa.repository.AddressesRepository;
import com.example.testjpa.repository.WorkersRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/addresses")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class AddressesController {
    private AddressesRepository addressesRepository;

    private List<WorkerXResponseDto> workersToDto(List<Worker> workers) {
        return workers.stream().map(
                worker -> WorkerXResponseDto.builder()
                        .id(worker.getId())
                        .name(worker.getName())
                        .build()
        ).collect(Collectors.toList());
    }

    @GetMapping(value = "/get-all")
    public List<AddressXResponseDto> getAll() {
        return addressesRepository.findAll().stream().map(
                address -> AddressXResponseDto.builder()
                        .id(address.getId())
                        .home(address.getHome())
                        .street(address.getStreet())
                        .workers(workersToDto(address.getWorkers()))
                        .build()
        ).collect(Collectors.toList());

//        List<Address> temp = addressesRepository.findAll();
//
//        return temp;
    }

    @GetMapping(value = "/get-by-id/{id}")
    public Address getById(@PathVariable int id) {
        Address temp = addressesRepository.findById(id).get();

        return temp;
    }

    @DeleteMapping(value = "delete-by-id/{id}")
    public void deleteById(@PathVariable int id) {
        addressesRepository.deleteById(id);
    }
}
