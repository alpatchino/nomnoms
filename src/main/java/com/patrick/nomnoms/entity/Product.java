package com.patrick.nomnoms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name="products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer objectId;

    @Column(name = "tpnc", nullable = false)
    private Integer tpnc;

    @Column(name = "image_url", nullable = false)
    private String image;

    @Column(name = "super_department", nullable = false)
    private String superDepartment;

    @Column(name = "tpnb",  nullable = false)
    private Integer tpnb;

    @Column(name = "contents_measure_type", nullable = false)
    private String contentsMeasureType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unit_of_sale", nullable = false)
    private Integer unitOfSale;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "avg_selling_unit_wt", nullable = false)
    private Double averageSellingUnitWeight;

    @Column(name = "unit_quantity", nullable = false)
    private String unitQuantity;

    @Column(name = "contents_quantity", nullable = false)
    private Integer contentsQuantity;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "unit_price", nullable = false)
    private Double unitprice;

    public Product(){}

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getTpnc() {
        return tpnc;
    }

    public void setTpnc(Integer tpnc) {
        this.tpnc = tpnc;
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
