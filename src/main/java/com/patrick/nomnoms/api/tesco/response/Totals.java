
package com.patrick.nomnoms.api.tesco.response;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all",
    "new",
    "offer"
})
public class Totals {

    @JsonProperty("all")
    private Integer all;
    @JsonProperty("new")
    private Integer _new;
    @JsonProperty("offer")
    private Integer offer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("all")
    public Integer getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(Integer all) {
        this.all = all;
    }

    @JsonProperty("new")
    public Integer getNew() {
        return _new;
    }

    @JsonProperty("new")
    public void setNew(Integer _new) {
        this._new = _new;
    }

    @JsonProperty("offer")
    public Integer getOffer() {
        return offer;
    }

    @JsonProperty("offer")
    public void setOffer(Integer offer) {
        this.offer = offer;
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
