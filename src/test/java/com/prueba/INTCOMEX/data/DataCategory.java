package com.prueba.INTCOMEX.data;

import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.DTO.CategoriesDTO;
import com.prueba.INTCOMEX.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataCategory {

    public static CategoriesDTO getCategoryDto(){

       return CategoriesDTO.builder()
                .categoryID(1L)
                .categoryName("Test Category")
                .description("Test Description")
                .build();
    }

}
