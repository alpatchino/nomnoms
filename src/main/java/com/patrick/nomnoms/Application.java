package com.patrick.nomnoms;

import com.patrick.nomnoms.api.tesco.TescoService;
import com.patrick.nomnoms.api.tesco.TescoSiteParser;
import com.patrick.nomnoms.entity.NutritionalInfo;
import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.service.AmazonService;
import com.patrick.nomnoms.service.ProductService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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

	@Autowired
	private AmazonService amazonService;

	public static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void test() {
		log.info("Application started...");

		String tpnc = "261385173";

		List<Product> products = tescoService.searchGroceries("cereal", 0, 10);

		for (Product product : products) {
			log.info("Saving product {} to database", product.getName());
			productService.saveProduct(product);
		}


	}

/*	@EventListener(ApplicationReadyEvent.class)
	public void jsoupInit(){

		String url = "https://www.tesco.com/groceries/en-GB/products/261385173";

		try {

			Document doc = Jsoup.connect(url).get();
			String title = doc.title();

			Element table = doc.select("table[class=product__info-table]").first();

			NutritionalValues nutritionalValues = new NutritionalValues();

			log.info("Table here: " + table.toString());

			for(Element row : table.select("tr")){

				// title
				String titleRow = row.child(0).ownText();

				if(titleRow.equalsIgnoreCase("Energy")){

					Double energy = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setEnergy(energy);

				} else if(titleRow.equalsIgnoreCase("fat")){

					Double fat = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setFat(fat);

				} else if(titleRow.equalsIgnoreCase("of which saturates")){

					Double ofWhichSaturates = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setFatSaturates(ofWhichSaturates);

				} else if(titleRow.equalsIgnoreCase("carbohydrates")){

					Double carbohydrates = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setCarbohydrates(carbohydrates);

				} else if(titleRow.equalsIgnoreCase("of which sugars")){

					Double ofWhichSugars = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setCarbSugars(ofWhichSugars);

				} else if(titleRow.equalsIgnoreCase("fibre")){

					Double fibre = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setFibre(fibre);

				} else if(titleRow.equalsIgnoreCase("protein")){

					Double protein = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setProtein(protein);

				} else if(titleRow.equalsIgnoreCase("salt")){

					Double salt = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
					nutritionalValues.setSalt(salt);
				} else {
					log.error("Macronutrient not recognised: {}", titleRow);
				}





				// per 100g
				String s2 = row.child(1).ownText();

				// maybe per serving
				String s3 =  row.child(2).ownText();

			}


			Element productDescription = doc.getElementById("product-description");
			log.info("Product description: {}", productDescription.toString());

			String s = productDescription.ownText();


			Element ingredients = doc.getElementById("ingredients");
			log.info("Ingredients: {}", ingredients);

			Element placeOfOrigin = doc.getElementById("origin-information-produce-of");
			log.info("Place of origin: {}", placeOfOrigin);

			Element numberOfUses = doc.getElementById("uses");
			log.info("Number of uses: {}", numberOfUses);




		} catch (IOException e) {
			e.printStackTrace();
		}


	}





=======
>>>>>>> 7056cacbbf56a5add53c32b5917c04881cc5bc34
	public void init(){


<<<<<<< HEAD
			log.info("Saving product {}", product);

			Product savedEntity = productService.saveProduct(product);

			log.info("... product {} saved!", savedEntity.getObjectId());
		}
    }*/




}
