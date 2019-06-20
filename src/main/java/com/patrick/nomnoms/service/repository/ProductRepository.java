package com.patrick.nomnoms.service.repository;

import com.patrick.nomnoms.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "SELECT * FROM PRODUCTS WHERE UNIT_QUANTITY =?1",
            nativeQuery = true)
    Iterable<Product> searchByDepartment(String department);




}