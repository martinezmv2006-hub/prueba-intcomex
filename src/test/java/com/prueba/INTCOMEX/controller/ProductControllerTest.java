package com.prueba.INTCOMEX.controller;

import com.prueba.INTCOMEX.data.DataProduct;
import com.prueba.INTCOMEX.model.DTO.CategoriesDTO;
import com.prueba.INTCOMEX.model.DTO.ProductsDTO;
import com.prueba.INTCOMEX.model.Products;
import com.prueba.INTCOMEX.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Test
    public void test_createProduct_validInput() {
        ProductRepository productRepositoryMock = Mockito.mock(ProductRepository.class);
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProductName("Test Product 2");

        CategoriesDTO categoriesDTO = new CategoriesDTO();
        categoriesDTO.setCategoryID(1L);

        productsDTO.setCategories(categoriesDTO);

        when(productRepositoryMock.save(any(Products.class))).thenReturn(DataProduct.getProduct());
        ResponseEntity<String> response = productController.createProduct(productsDTO);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void test_valid_pageable() {
        Pageable pageable = PageRequest.of(0, 10);

        ProductRepository productRepositoryMock = Mockito.mock(ProductRepository.class);
        when(productRepositoryMock.findAll(any(Pageable.class))).thenReturn(DataProduct.getProducts());

        ResponseEntity<String> response = productController.getProducts(0, 10);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    public void test_invalid_product_id() {

        Integer invalidProductId = 1;

        ProductRepository productRepositoryMock = Mockito.mock(ProductRepository.class);
        when(productRepositoryMock.findById(anyInt())).thenReturn(DataProduct.getProductOpc());

        ResponseEntity<String> response = productController.getProductById(invalidProductId);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

}