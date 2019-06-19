package com.patrick.nomnoms;

import com.patrick.nomnoms.api.tesco.TescoService;
import com.patrick.nomnoms.entity.NutritionalValues;
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
	public void init(){

		log.info("------------------API TEST CALLS HERE -------------------------");
		List<Product> products = tescoService.testFlow("chicken mayo");

		for (Product product : products) {

			NutritionalValues nv = getNutritionalValuesFromPage(product.getTpnc().toString());

			log.info("Saving product {}", product);

			Product savedEntity = productService.saveProduct(product);

			log.info("... product {} saved!", savedEntity.getObjectId());
		}
    }

    public NutritionalValues getNutritionalValuesFromPage(String tpnc){

		String url = "https://www.tesco.com/groceries/en-GB/products/" + tpnc;
		log.info("Getting Nutritional Info from {}", url);

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

			}


			Element productDescription = doc.getElementById("product-description");
			log.info("Product description: {}", productDescription);
			nutritionalValues.setDescription(productDescription.ownText());

			Element ingredients = doc.getElementById("ingredients");
			log.info("Ingredients: {}", ingredients);
			nutritionalValues.setIngredients(ingredients.ownText());

			Element placeOfOrigin = doc.getElementById("origin-information-produce-of");
			log.info("Place of origin: {}", placeOfOrigin);
			nutritionalValues.setPlaceOfOrigin(placeOfOrigin.ownText());

			Element numberOfUses = doc.getElementById("uses");
			log.info("Number of uses: {}", numberOfUses);
			nutritionalValues.setNumberOfUses(numberOfUses.ownText());

			return nutritionalValues;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
