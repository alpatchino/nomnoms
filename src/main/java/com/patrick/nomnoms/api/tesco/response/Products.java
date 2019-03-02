
package com.patrick.nomnoms.api.tesco.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "input_query",
    "output_query",
    "filters",
    "queryPhase",
    "totals",
    "config",
    "results",
    "suggestions"
})
public class Products {

    @JsonProperty("input_query")
    private String inputQuery;
    @JsonProperty("output_query")
    private String outputQuery;
    @JsonProperty("filters")
    private Filters filters;
    @JsonProperty("queryPhase")
    private String queryPhase;
    @JsonProperty("totals")
    private Totals totals;
    @JsonProperty("config")
    private String config;
    @JsonProperty("results")
    private List<Result> results = null;
    @JsonProperty("suggestions")
    private List<Object> suggestions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("input_query")
    public String getInputQuery() {
        return inputQuery;
    }

    @JsonProperty("input_query")
    public void setInputQuery(String inputQuery) {
        this.inputQuery = inputQuery;
    }

    @JsonProperty("output_query")
    public String getOutputQuery() {
        return outputQuery;
    }

    @JsonProperty("output_query")
    public void setOutputQuery(String outputQuery) {
        this.outputQuery = outputQuery;
    }

    @JsonProperty("filters")
    public Filters getFilters() {
        return filters;
    }

    @JsonProperty("filters")
    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    @JsonProperty("queryPhase")
    public String getQueryPhase() {
        return queryPhase;
    }

    @JsonProperty("queryPhase")
    public void setQueryPhase(String queryPhase) {
        this.queryPhase = queryPhase;
    }

    @JsonProperty("totals")
    public Totals getTotals() {
        return totals;
    }

    @JsonProperty("totals")
    public void setTotals(Totals totals) {
        this.totals = totals;
    }

    @JsonProperty("config")
    public String getConfig() {
        return config;
    }

    @JsonProperty("config")
    public void setConfig(String config) {
        this.config = config;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    @JsonProperty("suggestions")
    public List<Object> getSuggestions() {
        return suggestions;
    }

    @JsonProperty("suggestions")
    public void setSuggestions(List<Object> suggestions) {
        this.suggestions = suggestions;
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
