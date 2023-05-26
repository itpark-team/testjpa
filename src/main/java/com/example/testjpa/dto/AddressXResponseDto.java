package com.example.testjpa.dto;

import com.example.testjpa.model.Worker;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressXResponseDto {
    private int id;
    private String street;
    private int home;
    private List<WorkerXResponseDto> workers;
}
