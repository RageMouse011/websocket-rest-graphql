package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "cities_id_seq",
            allocationSize = 1
    )
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="population")
    private int population;
    @Column(name="area")
    private double area;

}
