package com.patrick.nomnoms.service.repository;

import com.patrick.nomnoms.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findAll();

    @Query("SELECT p FROM Product p ORDER BY p.nutritionalInfo.protein DESC")
    Iterable<Product> findAllOrderByHighestProteinDesc();

    @Query("SELECT p FROM Product p ORDER BY p.nutritionalInfo.fat ASC")
    Iterable<Product> findAllOrderByFatAsc();

    @Query("SELECT p FROM Product p ORDER BY p.nutritionalInfo.carbohydrates ASC")
    Iterable<Product> findAllOrderByCarbsAsc();

    @Query("SELECT p FROM Product p ORDER BY p.nutritionalInfo.salt ASC")
    Iterable<Product> findAllOrderBySaltAsc();

}