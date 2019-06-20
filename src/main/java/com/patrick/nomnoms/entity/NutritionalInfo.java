package com.patrick.nomnoms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "nutritional_info")
public class NutritionalInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer objectId;

    private Double energy;
    private Double fat;
    private Double fatSaturates;
    private Double carbohydrates;
    private Double carbSugars;
    private Double fibre;
    private Double protein;
    private Double salt;
    private Double calcium;
    private Double iron;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
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

    @Override
    public String toString() {
        return "NutritionalInfo{" +
                "objectId=" + objectId +
                ", energy=" + energy +
                ", fat=" + fat +
                ", fatSaturates=" + fatSaturates +
                ", carbohydrates=" + carbohydrates +
                ", carbSugars=" + carbSugars +
                ", fibre=" + fibre +
                ", protein=" + protein +
                ", salt=" + salt +
                '}';
    }

    public Double getCalcium() {
        return calcium;
    }

    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    public Double getIron() {
        return iron;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }
}
