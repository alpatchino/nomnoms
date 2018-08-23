package com.patrick.nomnoms.repository;

import com.patrick.nomnoms.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByProteinGreaterThanEqual(Integer proteinContent);

    List<Product> findByFatLessThan(Integer fatContent);
/*
    @Query(value = "SELECT * FROM PRODUCT WHERE ",
            nativeQuery = true)
    List<Product> findByBestProteinToPriceRatio();*/


}
