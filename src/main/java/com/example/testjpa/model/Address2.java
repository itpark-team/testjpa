package com.example.testjpa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "addresses2")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "home")
    private int home;

    @ManyToMany(mappedBy = "addresses2")
//    @JsonBackReference
//    @ManyToMany
//    @JoinTable(
//            name = "workers2_addresses2",
//            joinColumns = @JoinColumn(name = "addresses2_id"),
//            inverseJoinColumns = @JoinColumn(name = "workers2_id")
//    )
    private List<Worker2> workers2 = new ArrayList<>();
}
