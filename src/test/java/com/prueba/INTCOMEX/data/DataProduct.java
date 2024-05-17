package com.prueba.INTCOMEX.data;

import com.prueba.INTCOMEX.model.Categories;
import com.prueba.INTCOMEX.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataProduct {

    public static Products getProduct(){

       return Products.builder()
                .productID(1L)
                .productName("test product")
                .categories(
                        Categories.builder()
                                .categoryID(1L)
                                .categoryName("Test Category")
                                .build()
                )
                .build();
    }


    public static Page<Products> getProducts(){


        List<Products> productList = new ArrayList<>();
        for(int x=1; x<12; x++){
            productList.add(
                    Products.builder()
                    .productID(1L)
                    .productName("test product")
                    .categories(
                            Categories.builder()
                                    .categoryID(1L)
                                    .categoryName("Test Category")
                                    .build()
                    )
                    .build()
            );
        }

        Page<Products> page = new PageImpl<>(productList);
        return page;
    }

    public static Optional<Products> getProductOpc(){
        return Optional.of(
                Products.builder()
                        .productID(1L)
                        .productName("test product")
                        .categories(
                                Categories.builder()
                                        .categoryID(1L)
                                        .categoryName("Test Category")
                                        .build()
                        ).build()
        );
    }

}
