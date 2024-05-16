package com.prueba.INTCOMEX.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {

    @JsonProperty("categoryID")
    private Long categoryID;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("picture")
    private byte[] picture;
}