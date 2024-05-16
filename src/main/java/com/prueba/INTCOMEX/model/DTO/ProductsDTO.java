package com.prueba.INTCOMEX.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.INTCOMEX.model.Suppliers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {

    @JsonProperty("productID")
    private Long productID;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("suppliers")
    private Suppliers suppliers;

    @JsonProperty("categories")
    private CategoriesDTO categories;

    @JsonProperty("quantityPerUnit")
    private String quantityPerUnit;

    @JsonProperty("unitPrice")
    private double unitPrice;

    @JsonProperty("unitsInStock")
    private int unitsInStock;

    @JsonProperty("unitsOnOrder")
    private int unitsOnOrder;

    @JsonProperty("reorderLevel")
    private int reorderLevel;

    @JsonProperty("discontinued")
    private boolean discontinued;

}
