package com.prueba.INTCOMEX.repositories;

import com.prueba.INTCOMEX.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

    Optional<Categories> findCategoriesByCategoryID(Long id);

    Optional<Categories> findCategoriesByCategoryName(String name);

}
