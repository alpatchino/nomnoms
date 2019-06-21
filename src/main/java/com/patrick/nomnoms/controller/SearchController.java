package com.patrick.nomnoms.controller;

import com.patrick.nomnoms.api.tesco.TescoService;
import com.patrick.nomnoms.api.tesco.TescoSiteParser;
import com.patrick.nomnoms.entity.NutritionalInfo;
import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {

    public static final Logger log = LoggerFactory.getLogger(SearchController.class);

    private ProductService productService;
    private TescoService tescoService;

    @Autowired
    public void setProductService(ProductService service){
        this.productService = service;
    }

    @Autowired
    public void setTescoService(TescoService tescoService) {
        this.tescoService = tescoService;
    }

    @RequestMapping(value = "/{query}", method = RequestMethod.GET)
    public Iterable<Product> search(@PathVariable String query){

/*        log.info("Searching for {}", query);

        log.info("------------------API TEST CALLS HERE -------------------------");
        List<Product> products = tescoService.testFlow("muesli");


        for (Product product : products) {

            NutritionalInfo nutritionalInfo = TescoSiteParser
                    .getNutritionalInfoFromTnpc(product.getTpnc().toString());

            product.setNutritionalInfo(nutritionalInfo);

            Product saved = productService.saveProduct(product);

            log.info("Product saved: {}", saved);

        }*/

        //return productService.searchProducts(query);

        return  null;
    }
}