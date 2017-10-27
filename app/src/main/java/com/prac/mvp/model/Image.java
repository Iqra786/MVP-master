package com.prac.mvp.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prac.mvp.exception.DataNoAvailableException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    private String imageLink;
    private String imageSize;

    @JsonCreator
    public Image(@JsonProperty(value = "#text") String imageLink, @JsonProperty(value = "size")String imageSize) {
        this.imageLink = imageLink;
        this.imageSize = imageSize;
    }

    public String getImageLink() throws DataNoAvailableException {
        return imageLink;
    }

    public String getImageSize() throws DataNoAvailableException {
        return imageSize;
    }


}
