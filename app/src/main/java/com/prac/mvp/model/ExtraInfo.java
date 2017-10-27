package com.prac.mvp.model;


import com.prac.mvp.exception.DataNoAvailableException;

import java.io.Serializable;
import java.util.List;

public class ExtraInfo implements Serializable {

    private String url;
    private List<Image> images;
    private String Stream;
    private String mBId;
    private String artistName;
    private String listener;


    public String getUrl()  throws DataNoAvailableException {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Image> getImages() throws DataNoAvailableException {
        return images;

    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getStream() throws DataNoAvailableException{
        return Stream;
    }

    public void setStream(String stream) {
        Stream = stream;
    }

    public String getmBId() throws DataNoAvailableException{
        return mBId;

    }

    public void setmBId(String mBId) {
        this.mBId = mBId;
    }

    public String getArtistName() throws DataNoAvailableException {
        return artistName;

    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getListener()  throws DataNoAvailableException {
        return listener;

    }

    public void setListener(String listener) {
        this.listener = listener;
    }
}
