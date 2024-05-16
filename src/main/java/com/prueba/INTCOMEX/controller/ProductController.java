package com.prueba.INTCOMEX.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.INTCOMEX.model.DTO.ProductsDTO;
import com.prueba.INTCOMEX.model.Products;
import com.prueba.INTCOMEX.services.ProductServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
@Tag(name = "Product resources")
public class ProductController {

    @Autowired
    private ProductServices service;

    @Operation(summary = "post for product creation")
    @PostMapping(path = "product/create", consumes = "application/json; charset=utf-8")
    public ResponseEntity<String> createProduct(@RequestBody ProductsDTO productsDTO)  {
        try {
            log.info("Get Number Card"+productsDTO);

            Long idProduct = service.createProduct(productsDTO);

            return ResponseEntity.status(200).body(idProduct.toString());
        } catch (Exception e) {
            log.info("Error while trying to productsDTO, with message: "+ e.getMessage());

            return ResponseEntity.status(500).body("Could not get all Employee");
        }
    }

    @Operation(summary = "get to bring all the products with their pagination")
    @GetMapping("product/findAll")
    public ResponseEntity<String> getProducts(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<Products> listProducts = service.getProducts(pageRequest);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return ResponseEntity.status(200).body(objectMapper.writeValueAsString(listProducts));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al convertir la lista de productos a JSON");
        }
    }

    @Operation(summary = "get to fetch all a product by id")
    @GetMapping("product/find")
    public ResponseEntity<String> getProductById(@RequestParam Integer idProducts) {
        Products products = service.getProduct(idProducts);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return ResponseEntity.status(200).body(objectMapper.writeValueAsString(products));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al convertir la lista de productos a JSON");
        }
    }

}
