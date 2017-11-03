package com.prac.mvp.repository;

import com.prac.mvp.exception.DataNotAvailableException;
import com.prac.mvp.model.Album;

import java.util.List;

public interface AlbumRepository {

List<Album> albumResult() throws DataNotAvailableException;

}
