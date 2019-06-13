
package com.patrick.nomnoms.api.tesco.response;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "superDepartment",
    "tpnb",
    "ContentsMeasureType",
    "name",
    "UnitOfSale",
    "description",
    "AverageSellingUnitWeight",
    "UnitQuantity",
    "id",
    "ContentsQuantity",
    "department",
    "price",
    "unitprice"
})
public class Result {

    @JsonProperty("image")
    private String image;
    @JsonProperty("superDepartment")
    private String superDepartment;
    @JsonProperty("tpnb")
    private Integer tpnb;
    @JsonProperty("ContentsMeasureType")
    private String contentsMeasureType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("UnitOfSale")
    private Integer unitOfSale;
    @JsonProperty("description")
    private List<String> description = null;
    @JsonProperty("AverageSellingUnitWeight")
    private Double averageSellingUnitWeight;
    @JsonProperty("UnitQuantity")
    private String unitQuantity;
    @JsonProperty("id")
    private Integer tpnc;
    @JsonProperty("ContentsQuantity")
    private Integer contentsQuantity;
    @JsonProperty("department")
    private String department;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("unitprice")
    private Double unitprice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("superDepartment")
    public String getSuperDepartment() {
        return superDepartment;
    }

    @JsonProperty("superDepartment")
    public void setSuperDepartment(String superDepartment) {
        this.superDepartment = superDepartment;
    }

    @JsonProperty("tpnb")
    public Integer getTpnb() {
        return tpnb;
    }

    @JsonProperty("tpnb")
    public void setTpnb(Integer tpnb) {
        this.tpnb = tpnb;
    }

    @JsonProperty("ContentsMeasureType")
    public String getContentsMeasureType() {
        return contentsMeasureType;
    }

    @JsonProperty("ContentsMeasureType")
    public void setContentsMeasureType(String contentsMeasureType) {
        this.contentsMeasureType = contentsMeasureType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("UnitOfSale")
    public Integer getUnitOfSale() {
        return unitOfSale;
    }

    @JsonProperty("UnitOfSale")
    public void setUnitOfSale(Integer unitOfSale) {
        this.unitOfSale = unitOfSale;
    }

    @JsonProperty("description")
    public List<String> getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(List<String> description) {
        this.description = description;
    }

    @JsonProperty("AverageSellingUnitWeight")
    public Double getAverageSellingUnitWeight() {
        return averageSellingUnitWeight;
    }

    @JsonProperty("AverageSellingUnitWeight")
    public void setAverageSellingUnitWeight(Double averageSellingUnitWeight) {
        this.averageSellingUnitWeight = averageSellingUnitWeight;
    }

    @JsonProperty("UnitQuantity")
    public String getUnitQuantity() {
        return unitQuantity;
    }

    @JsonProperty("UnitQuantity")
    public void setUnitQuantity(String unitQuantity) {
        this.unitQuantity = unitQuantity;
    }

    @JsonProperty("tpnc")
    public Integer getTpnc() {
        return tpnc;
    }

    @JsonProperty("tpnc")
    public void setTpnc(Integer tpnc) {
        this.tpnc = tpnc;
    }

    @JsonProperty("ContentsQuantity")
    public Integer getContentsQuantity() {
        return contentsQuantity;
    }

    @JsonProperty("ContentsQuantity")
    public void setContentsQuantity(Integer contentsQuantity) {
        this.contentsQuantity = contentsQuantity;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("unitprice")
    public Double getUnitprice() {
        return unitprice;
    }

    @JsonProperty("unitprice")
    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
