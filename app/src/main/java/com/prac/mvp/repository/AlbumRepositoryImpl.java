package com.prac.mvp.repository;


import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.Album;
import com.prac.mvp.model.Result;

import java.util.List;

public class AlbumRepositoryImpl extends MatchItemRepository implements AlbumRepository {


    public AlbumRepositoryImpl(Result result) {
        super(result);
    }

    @Override
    public List<Album> albumResult() throws DataNotAvailableException {
        return getMatchItem().getAlbummatches().getAlbum();
    }
}
