package com.prac.mvp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prac.mvp.exception.DataNotAvailableException;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist extends ExtraInfo {

    private String artistName;

    public Artist(@JsonProperty(value = "name" ) String artistName, @JsonProperty(value = "url" ) String url , @JsonProperty(value = "image" ) List<Image> image , @JsonProperty(value = "streamable" ) String streamable , @JsonProperty(value = "mbid" ) String mbid , @JsonProperty(value = "listeners" ) String listeners ) {
        this.artistName = artistName;
        setListener(listeners);
        setmBId(mbid);
        setUrl(url);
        setStream(streamable);
        setImages(image);
    }

    @Override
    public String getArtistName() throws DataNotAvailableException {
        return artistName;
    }

    @Override
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
