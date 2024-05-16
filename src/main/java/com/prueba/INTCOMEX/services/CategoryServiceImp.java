package com.prueba.INTCOMEX.services;

import com.prueba.INTCOMEX.mappers.CategoriesMapper;
import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.DTO.CategoriesDTO;
import com.prueba.INTCOMEX.repositories.CategoryRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log
@Service
public class CategoryServiceImp implements CategoryService{


    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoriesMapper mapper;

    public CategoryServiceImp(CategoryRepository categoryRepository, CategoriesMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public Long createCategory(CategoriesDTO categoriesDTO) {
        Categories categories = mapper.toEntity(categoriesDTO);
        categoryRepository.save(categories);
        log.info("Save category"+categoriesDTO);
        return categories.getCategoryID();
    }

    @Override
    public Categories getCategoriesById(Long id) {
        Optional<Categories> categoriesOpt = categoryRepository.findCategoriesByCategoryID(id);
        if(!categoriesOpt.isEmpty()) {
            return categoriesOpt.get();
        }
        return null;
    }

    @Override
    public Categories getCategoriesByName(String name) {
        Optional<Categories> categoriesOpt = categoryRepository.findCategoriesByCategoryName(name);
        if(!categoriesOpt.isEmpty()) {
            return categoriesOpt.get();
        }
        return null;
    }
}
