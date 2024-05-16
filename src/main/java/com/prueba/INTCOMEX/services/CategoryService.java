package com.prueba.INTCOMEX.services;

import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.DTO.CategoriesDTO;

import java.util.List;

public interface CategoryService {

    Long createCategory(CategoriesDTO categoriesDTO);

    Categories getCategoriesById(Long id);

    Categories getCategoriesByName(String name);


}
