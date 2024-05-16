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
@Table(name = "OrderDetail")
public class OrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "orderID")
    private Orders orders;

    @Id
    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "productID")
    private Products products;

    @Column(name = "UnitPrice")
    private double unitPrice;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Discount")
    private double discount;

}