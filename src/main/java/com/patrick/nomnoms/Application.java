package com.patrick.nomnoms;

import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Application {

	@Autowired
	private ProductRepository repository;

	public static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init(){

        List<Product> lowFatProducts = repository.findByFatLessThan(4);
        List<Product> highProteinProducts = repository.findByProteinGreaterThanEqual(100);

        log.info("Low far products");

        for(Product p : lowFatProducts){
            log.info(p.toString());
        }

        log.info("High protein products");

        for(Product p : highProteinProducts){
            log.info(p.toString());
        }
    }
}
