package com.prac.mvp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prac.mvp.exception.DataNotAvailableException;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track extends ExtraInfo {

    private String trackName;

    public Track(@JsonProperty(value = "name" ) String trackName , @JsonProperty(value = "artist" ) String artistName, @JsonProperty(value = "url" ) String url , @JsonProperty(value = "image" ) List<Image> image , @JsonProperty(value = "streamable" ) String streamable , @JsonProperty(value = "mbid" ) String mbid , @JsonProperty(value = "listeners" ) String listeners ) {
        this.trackName = trackName;
        setArtistName(artistName);
        setUrl(url);
        setStream(streamable);
        setListener(listeners);
        setImages(image);
    }

    public String getTrackName() throws DataNotAvailableException {
        return trackName;

    }

}
