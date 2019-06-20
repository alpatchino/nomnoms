package com.patrick.nomnoms.service;

import com.patrick.nomnoms.entity.Product;

import java.util.Optional;


public interface ProductService {

    /**
     *
     * @param product
     * @return
     */
    Product saveProduct(Product product);

    /**
     *
     * @param id
     * @return
     */
    Optional<Product> getProductById(Integer id);

    /**
     *
     * @return
     */
    Iterable<Product> listAllProducts();

    /**
     * Searches products table on title & description
     *
     * @param query
     * @return list of products, empty list if none found
     */
    Iterable<Product> searchProducts(String query);
}
