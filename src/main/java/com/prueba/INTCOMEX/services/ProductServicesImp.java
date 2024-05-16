package com.prueba.INTCOMEX.services;

import com.prueba.INTCOMEX.mappers.CategoriesMapper;
import com.prueba.INTCOMEX.mappers.ProductsMapper;
import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.DTO.ProductsDTO;
import com.prueba.INTCOMEX.model.Products;
import com.prueba.INTCOMEX.repositories.CategoryRepository;
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

    @Autowired
    private final ProductsMapper mapper;

    public ProductServicesImp(ProductRepository productRepository, ProductsMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public Long createProduct(ProductsDTO productsDTO) {
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
