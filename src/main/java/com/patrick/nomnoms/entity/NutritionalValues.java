package com.patrick.nomnoms.entity;

public class NutritionalValues {

    private String description;
    private String ingredients;
    private String placeOfOrigin;
    private String numberOfUses;

    private Double energy;
    private Double fat;
    private Double fatSaturates;
    private Double carbohydrates;
    private Double carbSugars;
    private Double fibre;
    private Double protein;
    private Double salt;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(String numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getFatSaturates() {
        return fatSaturates;
    }

    public void setFatSaturates(Double fatSaturates) {
        this.fatSaturates = fatSaturates;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getCarbSugars() {
        return carbSugars;
    }

    public void setCarbSugars(Double carbSugars) {
        this.carbSugars = carbSugars;
    }

    public Double getFibre() {
        return fibre;
    }

    public void setFibre(Double fibre) {
        this.fibre = fibre;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getSalt() {
        return salt;
    }

    public void setSalt(Double salt) {
        this.salt = salt;
    }
}
