package com.patrick.nomnoms.service.impl;

import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.service.ProductService;
import com.patrick.nomnoms.service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private ProductRepository repository;

    @Autowired
    public void setProductRepository(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {

        try {

            return repository.save(product);

        } catch (DataAccessException e) {
            log.error("Could not save product to database", e);
        }

        return null;
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return repository.findAll();
    }

}
