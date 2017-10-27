package com.prac.mvp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistMatcher {


    @JsonProperty("artist")
    List<Artist> artists = null;

    @JsonProperty("artist")
    public List<Artist> getArtists() throws NullPointerException {
        return artists;
    }

    @JsonProperty("artist")
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
