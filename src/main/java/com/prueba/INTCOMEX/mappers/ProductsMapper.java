package com.prueba.INTCOMEX.mappers;

import com.prueba.INTCOMEX.model.DTO.ProductsDTO;
import com.prueba.INTCOMEX.model.Products;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProductsMapper extends EntityMapper<ProductsDTO, Products>{
    ProductsDTO toDto(Products entity);

    Products toEntity(ProductsDTO dto);
}
