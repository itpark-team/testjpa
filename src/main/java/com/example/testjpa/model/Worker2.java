package com.example.testjpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "workers2")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "workers2_addresses2",
            joinColumns = @JoinColumn(name = "workers2_id"),
            inverseJoinColumns = @JoinColumn(name = "addresses2_id")
    )
    //@JsonManagedReference
    private List<Address2> addresses2 = new ArrayList<>();
}
