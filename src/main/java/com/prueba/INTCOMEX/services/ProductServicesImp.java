package com.prueba.INTCOMEX.services;

import com.prueba.INTCOMEX.mappers.CategoriesMapper;
import com.prueba.INTCOMEX.mappers.ProductsMapper;
import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.DTO.ProductsDTO;
import com.prueba.INTCOMEX.model.Products;
import com.prueba.INTCOMEX.repositories.ProductRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class ProductServicesImp implements ProductServices{

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    private final ProductsMapper mapper;

    private final CategoriesMapper categoriesMapper;

    public ProductServicesImp(ProductRepository productRepository, ProductsMapper mapper, CategoryService categoryService, CategoriesMapper categoriesMapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.categoryService = categoryService;
        this.categoriesMapper = categoriesMapper;
    }

    @Override
    public Long createProduct(ProductsDTO productsDTO) {

        long idCategory = productsDTO.getCategories().getCategoryID() == null ?
                0: productsDTO.getCategories().getCategoryID();
        String nameCategory = productsDTO.getCategories().getCategoryName();

        Categories category;

        if(idCategory>0){
            category = categoryService.getCategoriesById(idCategory);
        } else if (!nameCategory.isBlank()) {
            category = categoryService.getCategoriesByName(nameCategory);
        }else{
            log.info("A category was not specified.");
            return null;
        }

        productsDTO.setCategories(categoriesMapper.toDto(category));

        log.info(productsDTO.toString());

        Products products = mapper.toEntity(productsDTO);
        productRepository.save(products);
        log.info("Save products"+productsDTO);
        return products.getProductID();
    }

    @Override
    public List<Products> getProducts(Pageable pageable) {
        Page<Products> page = productRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public Products getProduct(Integer idProducts) {
        Optional<Products> productsOpt = productRepository.findById(idProducts);
        if(productsOpt.isEmpty()) {
            return productsOpt.get();
        }
        return null;
    }
}
