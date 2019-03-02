package com.patrick.nomnoms.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer objectId;

    @Column(name = "tpnc")
    private Integer id;

    @Column(name = "image_url")
    private String image;

    @Column(name = "super_department")
    private String superDepartment;

    @Column(name = "tpnb")
    private Integer tpnb;

    @Column(name = "contents_measure_type")
    private String contentsMeasureType;

    @Column(name = "name")
    private String name;

    @Column(name = "unitOfSale")
    private Integer unitOfSale;

    @Column(name = "description")
    private String description;

    @Column(name = "avg_selling_unit_wt")
    private Double averageSellingUnitWeight;

    @Column(name = "unit_quantity")
    private String unitQuantity;

    @Column(name = "contents_quantity")
    private Integer contentsQuantity;

    @Column(name = "department")
    private String department;

    @Column(name = "price")
    private Double price;

    @Column(name = "unit_price")
    private Double unitprice;

    public Product(){}

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSuperDepartment() {
        return superDepartment;
    }

    public void setSuperDepartment(String superDepartment) {
        this.superDepartment = superDepartment;
    }

    public Integer getTpnb() {
        return tpnb;
    }

    public void setTpnb(Integer tpnb) {
        this.tpnb = tpnb;
    }

    public String getContentsMeasureType() {
        return contentsMeasureType;
    }

    public void setContentsMeasureType(String contentsMeasureType) {
        this.contentsMeasureType = contentsMeasureType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitOfSale() {
        return unitOfSale;
    }

    public void setUnitOfSale(Integer unitOfSale) {
        this.unitOfSale = unitOfSale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAverageSellingUnitWeight() {
        return averageSellingUnitWeight;
    }

    public void setAverageSellingUnitWeight(Double averageSellingUnitWeight) {
        this.averageSellingUnitWeight = averageSellingUnitWeight;
    }

    public String getUnitQuantity() {
        return unitQuantity;
    }

    public void setUnitQuantity(String unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    public Integer getContentsQuantity() {
        return contentsQuantity;
    }

    public void setContentsQuantity(Integer contentsQuantity) {
        this.contentsQuantity = contentsQuantity;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }
}
