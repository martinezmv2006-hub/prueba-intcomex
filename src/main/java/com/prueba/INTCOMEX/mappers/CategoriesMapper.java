package com.prueba.INTCOMEX.mappers;

import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.DTO.CategoriesDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CategoriesMapper extends EntityMapper<CategoriesDTO, Categories>{
    CategoriesDTO toDto(Categories entity);

    Categories toEntity(CategoriesDTO dto);
}
