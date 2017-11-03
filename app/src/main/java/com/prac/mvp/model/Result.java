package com.prac.mvp.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {


    @JsonProperty("results")
    private MatchItem matchItem;
    @JsonProperty("message")
    private String message;
    @JsonProperty("error")
    private String error;


    @JsonCreator
    public Result(@JsonProperty(value = "results") MatchItem matchItem, @JsonProperty("message") String message, @JsonProperty("error") String error) {
        this.matchItem = matchItem;
        this.message = message;
        this.error = error;

    }


    @JsonProperty("results")
    public MatchItem getMatchItem() {
        return matchItem;
    }

}
