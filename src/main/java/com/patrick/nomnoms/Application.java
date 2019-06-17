package com.patrick.nomnoms;

import com.patrick.nomnoms.api.tesco.TescoService;
import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.service.ProductService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.Iterator;
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
	public void jsoupInit(){

		String url = "https://www.tesco.com/groceries/en-GB/products/261385173";

		try {
			Document doc = Jsoup.connect(url).get();
			String title = doc.title();

			Element table = doc.select("table[class=product__info-table]").first();

			log.info("Table here: " + table.toString());

			for(Element row : table.select("tr")){

				String s1 = row.child(0).ownText();
				String s2 = row.child(1).ownText();
				String s3 =  row.child(2).ownText();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}





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
