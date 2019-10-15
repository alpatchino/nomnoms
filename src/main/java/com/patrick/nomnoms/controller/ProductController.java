package com.patrick.nomnoms.controller;

import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.service.ProductService;
import com.patrick.nomnoms.service.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    public static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        log.info("Retrieving all product...");
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> getAllProducts(@RequestParam Integer id) {
        log.info("Retrieving all product...");
        return repository.findById(id);
    }

    @RequestMapping(value = "/protein", method = RequestMethod.GET)
    public Iterable<Product> getAllProteinProducts() {
        log.info("Retrieving all protein product...");
        return repository.findAllOrderByHighestProteinDesc();
    }

    @RequestMapping(value = "/fat", method = RequestMethod.GET)
    public Iterable<Product> getAllFatProducts() {
        log.info("Retrieving all fat product...");
        return repository.findAllOrderByFatAsc();
    }

    @RequestMapping(value = "/carbs", method = RequestMethod.GET)
    public Iterable<Product> getAllCarbsProducts() {
        log.info("Retrieving all carbs product...");
        return repository.findAllOrderByCarbsAsc();
    }

    @RequestMapping(value = "/salt", method = RequestMethod.GET)
    public Iterable<Product> getAllSaltProducts() {
        log.info("Retrieving all salt product...");
        return repository.findAllOrderBySaltAsc();
    }



/*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable Integer id) {
        log.info("Retrieving single product {}...", id);
        return service.getProductById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        log.info("Creating new product {}...", product);
        return service.saveProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        log.info("Updating product {}...", product.getTpnc());
        product.setTpnc(id);
        return service.saveProduct(product);
    }

    @RequestMapping(value = "/best", method = RequestMethod.GET)
<<<<<<< Updated upstream
    public Iterable<Product> getBestProtein() {
        log.info("Getting best protein {}...");
=======
    public Iterable<Product> getBestProtein(){
        log.info("Getting best protein ...");
>>>>>>> Stashed changes
        return service.listBestProteinProducts();
    }*/


}
