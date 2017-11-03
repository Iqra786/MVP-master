package com.prac.mvp.repository;


import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.Artist;

import java.util.List;

public interface ArtistRepository {
    List<Artist> artistResults() throws DataNotAvailableException;
}
