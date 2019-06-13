package com.patrick.nomnoms.service.repository;

import com.patrick.nomnoms.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {


}