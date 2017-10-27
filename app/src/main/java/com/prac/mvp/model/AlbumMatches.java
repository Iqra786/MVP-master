package com.prac.mvp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;



@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumMatches {

    @JsonProperty("album")
    private List<Album> album = null;


    @JsonProperty("album")
    public List<Album> getAlbum() throws NullPointerException {
        return album;
    }

}
