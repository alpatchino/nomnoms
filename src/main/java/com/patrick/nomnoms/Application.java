package com.patrick.nomnoms;

import com.patrick.nomnoms.api.tesco.TescoService;
import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class Application {

	@Autowired
    private TescoService tescoService;

	@Autowired
	private ProductService productService;

	public static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init(){

		log.info("------------------API TEST CALLS HERE -------------------------");
		List<Product> products = tescoService.testFlow("fish");

		for (Product product : products) {

			log.info("Saving product {}", product);

			Product savedEntity = productService.saveProduct(product);

			log.info("... product {} saved!", savedEntity.getObjectId());
		}
    }

}
