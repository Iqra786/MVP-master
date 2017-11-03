package com.prac.mvp.dao;

import com.prac.mvp.android.Options;
import com.prac.mvp.model.Result;



public interface ResultDAO {
    rx.Observable<Result> getResult(String search , Options searchMethod);
}
