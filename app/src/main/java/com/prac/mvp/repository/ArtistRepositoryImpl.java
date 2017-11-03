package com.prac.mvp.repository;


import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.Artist;
import com.prac.mvp.model.Result;

import java.util.List;

public class ArtistRepositoryImpl extends MatchItemRepository implements ArtistRepository {


    public ArtistRepositoryImpl(Result result) {
        super(result);
    }

    @Override
    public List<Artist> artistResults() throws DataNotAvailableException {
        return getMatchItem().getArtists().getArtists();
    }

}
