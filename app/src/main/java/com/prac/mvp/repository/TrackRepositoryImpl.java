package com.prac.mvp.repository;


import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.Result;
import com.prac.mvp.model.Track;

import java.util.List;

public class TrackRepositoryImpl extends MatchItemRepository implements TrackRepository {

    public TrackRepositoryImpl(Result result) {
        super(result);
    }

    @Override
    public List<Track> trackResults() throws DataNotAvailableException {
        return getMatchItem().getTracks().getTracks();
    }
}
