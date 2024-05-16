package com.prueba.INTCOMEX.repositories;

import com.prueba.INTCOMEX.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    Page<Products> findAll(Pageable pageable);
}
