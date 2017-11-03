package com.prac.mvp.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prac.mvp.exception.DataNotAvailableException;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Album  extends ExtraInfo implements Serializable{

private String albumName;

    @JsonCreator
    public Album(@JsonProperty(value = "name" ) String albumName , @JsonProperty(value = "artist" ) String artistName, @JsonProperty(value = "url" ) String url , @JsonProperty(value = "image" ) List<Image> image , @JsonProperty(value = "streamable" ) String streamable , @JsonProperty(value = "mbid" ) String mbid )    {
        this.albumName = albumName;
        setArtistName(artistName);
        setUrl(url);
        setImages(image);
        setStream(streamable);
        setmBId(mbid);
    }

    public String getAlbumName() throws DataNotAvailableException {
        return albumName;
    }
}
