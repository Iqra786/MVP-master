package com.prac.mvp.repository;


import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.Track;

import java.util.List;

public interface TrackRepository {
List<Track> trackResults() throws DataNotAvailableException;
}
