package com.prueba.INTCOMEX.services;

import com.prueba.INTCOMEX.model.DTO.ProductsDTO;
import com.prueba.INTCOMEX.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductServices {
    Long createProduct(ProductsDTO productsDTO);

    List<Products> getProducts(Pageable pageable);

    Products getProduct(Integer id);

    Long createMassiveProduct(Integer count);
}
