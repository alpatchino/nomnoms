package com.patrick.nomnoms.repository;

import com.patrick.nomnoms.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
