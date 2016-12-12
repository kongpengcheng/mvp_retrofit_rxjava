package com.haier.mvp_retrofit_rxjava.date;

import com.haier.mvp_retrofit_rxjava.model.MainModel;
import com.haier.mvp_retrofit_rxjava.model.WeatherModelMPL;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Harry.Kong on 2016/12/10.
 */

public class DataManager {
    private String TAG = DataManager.class.getSimpleName();
    private static DataManager dataManager;
    WeatherModelMPL weatherModelMPL;

    public synchronized static DataManager getInstance() {
        synchronized (DataManager.class) {
            if (dataManager == null) {
                dataManager = new DataManager();
            }
        }

        return dataManager;
    }

    private DataManager() {
        this.weatherModelMPL = WeatherModelMPL.getInstance();
    }

    /**
     * 天气
     */
    public Observable<MainModel> getWeather(String baseUrl, String weatherId) {
        return weatherModelMPL.getWeather(baseUrl, weatherId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        //  .flatMap(result -> Observable.just(result.getData()));
    }
}


