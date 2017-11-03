package com.prac.mvp.repository;


import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.MatchItem;
import com.prac.mvp.model.Result;

public abstract class MatchItemRepository {

    private Result result;

    public MatchItemRepository(Result result) {
        this.result = result;
    }

    protected MatchItem getMatchItem() throws DataNotAvailableException {
        MatchItem searchItems;
        try {
            searchItems = result.getMatchItem();
        } catch (NullPointerException e) {
            throw new DataNotAvailableException("data not available");
        }
        return searchItems;
    }
}
