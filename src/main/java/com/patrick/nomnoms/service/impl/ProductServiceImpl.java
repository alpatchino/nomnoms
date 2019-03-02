package com.patrick.nomnoms.service.impl;

import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.repository.ProductRepository;
import com.patrick.nomnoms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setProductRepository(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
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
