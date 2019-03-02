package com.patrick.nomnoms;

import com.patrick.nomnoms.api.tesco.TescoService;
import com.patrick.nomnoms.api.tesco.response.GroceriesResponseVO;
import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Application {

	@Autowired
    private TescoService tescoService;

	@Autowired
	private ProductRepository repository;

	public static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init(){

		log.info("------------------API TEST CALLS HERE -------------------------");
		List<Product> products = tescoService.searchProduct("Salmon");

		for(Product product : products){

			log.info("Saving name={} id={} objectId={} tpnb={}",
					product.getName(),
					product.getId(),
					product.getObjectId(),
					product.getTpnb());

			repository.save(product);
		}
    }

}
