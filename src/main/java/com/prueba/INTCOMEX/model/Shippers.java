package com.prueba.INTCOMEX.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shippers")
public class Shippers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipperID")
    private Long shipperID;

    @Column(name = "ShipperName")
    private String shipperName;

    @Column(name = "Phone")
    private String phone;

}
