package com.patrick.nomnoms.api.tesco;

import com.patrick.nomnoms.entity.NutritionalInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TescoSiteParser {

    public static final Logger log = LoggerFactory.getLogger(TescoSiteParser.class);

    public static NutritionalInfo getNutritionalInfoFromTnpc(String tpnc){

        String url = "https://www.tesco.com/groceries/en-GB/products/" + tpnc;
        log.info("Getting Nutritional Info from {}", url);



        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            log.error("Could not parse document at {}", url);
            return null;
        }
        String title = doc.title();

        Element table = doc.select("table[class=product__info-table]").first();

        NutritionalInfo nutritionalInfo = new NutritionalInfo();

        log.debug("Table here: " + table.toString());

        for(Element row : table.select("tr")){

            // title
            String titleRow = row.child(0).ownText();

            if(titleRow.equalsIgnoreCase("Energy") ||
                    titleRow.equalsIgnoreCase("-") ||
                    titleRow.equalsIgnoreCase("kcal")){

                String energyString = row.child(1).ownText();

                // if '-' then usually means kcal with no units
                if(titleRow.equalsIgnoreCase("-")){
                    // get number next to kcal
                    energyString = energyString.replaceAll("[^0-9.]", "");
                    Double energy = Double.parseDouble(energyString);
                    nutritionalInfo.setEnergy(energy);
                    continue;
                }

                // if kcal then no units
                if(titleRow.equalsIgnoreCase("kcal")){
                    Double energy = Double.parseDouble(energyString);
                    nutritionalInfo.setEnergy(energy);
                    continue;
                }

                // if forward slash then two units in one line eg. 1300kJ / 260kcal
                if(energyString.contains("/")){
                    try {
                        // remove xkJ then extract number only
                        energyString = energyString.replaceAll("(\\d+\\s?kJ)", "");
                        energyString = energyString.replaceAll("[^0-9.]", "");
                        Double energy = Double.parseDouble(energyString);
                        nutritionalInfo.setEnergy(energy);
                        continue;
                    } catch (NumberFormatException e){
                        log.warn("Misformatted /, maybe next row");
                        continue;
                    }

                }


                energyString = energyString.replaceAll("(\\d+\\s?kJ)", "");
                if(StringUtils.isBlank(energyString)){
                    continue;
                }

                // get number next to kcal
                energyString = energyString.replaceAll("[^0-9.]", "");

                Double energy = Double.parseDouble(energyString);
                nutritionalInfo.setEnergy(energy);

            } else if(titleRow.equalsIgnoreCase("fat")){

                Double fat = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setFat(fat);

            } else if(titleRow.equalsIgnoreCase("of which saturates") ||
                    titleRow.equalsIgnoreCase("saturates")){

                Double ofWhichSaturates = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setFatSaturates(ofWhichSaturates);

            } else if(titleRow.equalsIgnoreCase("Carbohydrates") || titleRow.equalsIgnoreCase("carbohydrate")){

                Double carbohydrates = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setCarbohydrates(carbohydrates);

            } else if(titleRow.equalsIgnoreCase("of which sugars") || titleRow.equalsIgnoreCase("sugars")){

                Double ofWhichSugars = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setCarbSugars(ofWhichSugars);

            } else if(titleRow.equalsIgnoreCase("fibre")){

                Double fibre = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setFibre(fibre);

            } else if(titleRow.equalsIgnoreCase("protein")){

                Double protein = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setProtein(protein);

            } else if(titleRow.equalsIgnoreCase("salt")){

                Double salt = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setSalt(salt);

            } else if(titleRow.equalsIgnoreCase("calcium")){

                Double calcium = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setCalcium(calcium);

            } else if(titleRow.equalsIgnoreCase("iron")) {

                Double iron = Double.parseDouble(row.child(1).ownText().replaceAll("[^0-9.]", ""));
                nutritionalInfo.setIron(iron);
            } else {
                log.warn("Macronutrient not recognised: {}", titleRow);
            }

        }

        return nutritionalInfo;


    }
}
