package com.example.testjpa.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkerResponseDto {
    private int id;
    private String name;
//    private AddressResponseDto address;
    private int addressId;
    private String addressStreet;
    private int addressHome;
}
