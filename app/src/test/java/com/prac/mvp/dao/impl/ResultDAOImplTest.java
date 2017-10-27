package com.prac.mvp.dao.impl;

import com.prac.mvp.dao.RemoteResultDAO;
import com.prac.mvp.model.Result;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rx.Observable;

import static org.hamcrest.CoreMatchers.instanceOf;




public class ResultDAOImplTest {

    private RemoteResultDAO remoteResultDAO;
    private String search = "test123";
    private String apiKey = "2424424";
    private String format = "json";

    @Before
    public void setUp() throws Exception {

        remoteResultDAO = new RemoteResultDAOBuilder("http://ws.audioscrobbler.com").build();

    }

    @Test
    public void getArtist() throws Exception {
        Observable<Result> getArtist = remoteResultDAO.getRemoteArtists(search, apiKey, format);
        Assert.assertNotNull(getArtist);
        Assert.assertThat(getArtist , instanceOf(Observable.class) );
    }

    @Test
    public void getAlbum() throws Exception {
        Observable<Result> getAlbum = remoteResultDAO.getRemoteAlbums(search, apiKey, format);
        Assert.assertNotNull(getAlbum);
        Assert.assertThat(getAlbum , instanceOf(Observable.class) );

    }

    @Test
    public void getTrack() throws Exception {
        Observable<Result> getTrack = remoteResultDAO.getRemoteTracks(search, apiKey, format);
        Assert.assertNotNull(getTrack);
        Assert.assertThat(getTrack , instanceOf(Observable.class) );

    }

}