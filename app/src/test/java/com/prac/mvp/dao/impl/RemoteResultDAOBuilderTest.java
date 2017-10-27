package com.prac.mvp.dao.impl;

import com.prac.mvp.dao.RemoteResultDAO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;


public class RemoteResultDAOBuilderTest {

    private RemoteResultDAOBuilder remoteResultDAOBuilder;


    @Before
    public void setUp() throws Exception {
        remoteResultDAOBuilder = new RemoteResultDAOBuilder("http://ws.audioscrobbler.com");

    }

    @Test
    public void build() throws Exception {
        Assert.assertNotNull(remoteResultDAOBuilder.build());
        Assert.assertThat(remoteResultDAOBuilder.build() , instanceOf(RemoteResultDAO.class) );
    }

}