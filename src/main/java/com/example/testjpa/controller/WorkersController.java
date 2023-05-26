package com.example.testjpa.controller;

import com.example.testjpa.dto.AddressResponseDto;
import com.example.testjpa.dto.WorkerInsertRequestDto;
import com.example.testjpa.dto.WorkerResponseDto;
import com.example.testjpa.model.Address;
import com.example.testjpa.model.Worker;
import com.example.testjpa.repository.AddressesRepository;
import com.example.testjpa.repository.WorkersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/workers")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class WorkersController {

    private WorkersRepository workersRepository;
    private AddressesRepository addressesRepository;

    private AddressResponseDto addressToDto(Address address) {
        return AddressResponseDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .home(address.getHome())
                .build();
    }

    @GetMapping(value = "/get-all")
    public List<WorkerResponseDto> getAll() {

        return workersRepository.findAll().stream().map(
                worker -> WorkerResponseDto.builder()
                        .id(worker.getId())
                        .name(worker.getName())
                        .addressId(worker.getAddress().getId())
                        .addressStreet(worker.getAddress().getStreet())
                        .addressHome(worker.getAddress().getHome())
                        //.address(addressToDto(worker.getAddress()))
                        .build()
        ).collect(Collectors.toList());


//        List<Worker> temp = workersRepository.findAll();
//
//        return temp;
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
    public void deleteById(@PathVariable int id) {
        workersRepository.deleteById(id);
    }
}
