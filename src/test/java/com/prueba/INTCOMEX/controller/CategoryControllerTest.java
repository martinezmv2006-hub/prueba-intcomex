package com.prueba.INTCOMEX.controller;

import com.prueba.INTCOMEX.data.DataCategory;
import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Test
    public void test_createCategory_validInput() {

        CategoryRepository categoryRepositoryMock = Mockito.mock(CategoryRepository.class);

        Categories categories =Categories.builder()
                .categoryID(1L)
                .categoryName("Test Category")
                .description("Test Description")
                .build();

        when(categoryRepositoryMock.save(categories)).thenReturn(categories);

        ResponseEntity<String> response = categoryController.createCategory(DataCategory.getCategoryDto());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1", response.getBody());
    }

}