package com.prac.mvp.factory;


import com.prac.mvp.model.Result;

import rx.Observable;

public interface Search {
    Observable<Result> search(String search);
}
