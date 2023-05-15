package com.example.testjpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "home")
    private int home;

//    @OneToOne(mappedBy = "address")
//    private Worker worker;
//
//    @OneToMany(mappedBy = "address")
//    private List<Worker> workers = new ArrayList<>();

//    @ManyToMany(mappedBy = "addresses")
//    private List<Worker> workers = new ArrayList<>();
}
