package com.prac.mvp.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {

    private String message;
    private String error;

@JsonCreator
    public ApiError(@JsonProperty("message")String message, @JsonProperty("error") String error) {
        this.message = message;
        this.error = error;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
