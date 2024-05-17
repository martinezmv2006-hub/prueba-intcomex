package com.prueba.INTCOMEX.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Long productID;

    @Column(name = "ProductName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "SupplierID", referencedColumnName = "supplierID")
    private Suppliers suppliers;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "categoryID")
    private Categories categories;

    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;

    @Column(name = "UnitPrice")
    private double unitPrice;

    @Column(name = "UnitsInStock")
    private int unitsInStock;

    @Column(name = "UnitsOnOrder")
    private int unitsOnOrder;

    @Column(name = "ReorderLevel")
    private int reorderLevel;

    @Column(name = "Discontinued")
    private boolean discontinued;

}
