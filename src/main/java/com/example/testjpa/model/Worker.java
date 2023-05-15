package com.example.testjpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

//    @OneToOne
//    private Address address;

//    @ManyToMany
//    @JoinTable(
//            name = "workers_addresses",
//            joinColumns = { @JoinColumn(name = "worker_id") },
//            inverseJoinColumns = { @JoinColumn(name = "address_id") }
//    )
//    @OneToMany
//    @JoinTable(
//            name = "workers_addresses",
//            joinColumns = { @JoinColumn(name = "worker_id") },
//            inverseJoinColumns = { @JoinColumn(name = "address_id") }
//    )
//    private List<Address> addresses = new ArrayList<>();
}
