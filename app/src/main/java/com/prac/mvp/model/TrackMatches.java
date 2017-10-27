package com.prac.mvp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackMatches {

    @JsonProperty("track")
    List<Track> tracks = null;

    @JsonProperty("track")
    public List<Track> getTracks() throws NullPointerException {
        return tracks;

    }
}
