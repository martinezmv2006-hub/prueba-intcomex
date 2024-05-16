package com.prueba.INTCOMEX.controller;

import com.prueba.INTCOMEX.model.DTO.CategoriesDTO;
import com.prueba.INTCOMEX.services.CategoryService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Log
@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping(path = "category/create", consumes = "application/json; charset=utf-8")
    public ResponseEntity<String> createCategory(@RequestBody CategoriesDTO categoriesDTO)  {
        try {
            log.info("Get Number Card"+categoriesDTO);

            Long idCategory = service.createCategory(categoriesDTO);

            return ResponseEntity.status(200).body(idCategory.toString());
        } catch (Exception e) {
            log.info("Error while trying to Get Number Card, with message: "+ e.getMessage());

            return ResponseEntity.status(500).body("Could not get all Employee");
        }
    }
}
