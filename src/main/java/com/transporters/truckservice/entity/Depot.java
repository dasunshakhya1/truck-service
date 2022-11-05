package com.transporters.truckservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "depot_data")
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "depot_name",nullable = false,updatable = false,unique = true)
    private String name;
    @Column(nullable = false,unique = true,name = "short_code")
    private String shortCord;

}
