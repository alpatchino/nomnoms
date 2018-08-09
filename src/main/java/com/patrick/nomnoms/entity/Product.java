package com.patrick.nomnoms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Column(columnDefinition = "text")
    private String url;

    @Column(columnDefinition = "text")
    private String description;

    private Integer netContent;

    private Integer energy;

    private Integer fat;

    private Integer saturates;

    private Integer carbohydrates;

    private Integer sugars;

    private Integer fibre;

    private Integer protein;

    private Integer salt;

    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNetContent() {
        return netContent;
    }

    public void setNetContent(Integer netContent) {
        this.netContent = netContent;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getSaturates() {
        return saturates;
    }

    public void setSaturates(Integer saturates) {
        this.saturates = saturates;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Integer getSugars() {
        return sugars;
    }

    public void setSugars(Integer sugars) {
        this.sugars = sugars;
    }

    public Integer getFibre() {
        return fibre;
    }

    public void setFibre(Integer fibre) {
        this.fibre = fibre;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", netContent=" + netContent +
                ", energy=" + energy +
                ", fat=" + fat +
                ", saturates=" + saturates +
                ", carbohydrates=" + carbohydrates +
                ", sugars=" + sugars +
                ", fibre=" + fibre +
                ", protein=" + protein +
                ", salt=" + salt +
                ", price=" + price +
                '}';
    }
}
