package com.haier.mvp_retrofit_rxjava.model;

import com.haier.mvp_retrofit_rxjava.retrofit.RetrofitFactory;

import rx.Observable;

/**
 * Created by Harry.Kong on 2016/12/12.
 */

public class WeatherModelMPL implements IWeatherModel {

    private static WeatherModelMPL INSTANCE;

    public WeatherModelMPL() {
    }

    public synchronized static WeatherModelMPL getInstance() {
        if (null == INSTANCE) {
            synchronized (WeatherModelMPL.class) {
                if (null == INSTANCE) {
                    INSTANCE = new WeatherModelMPL();
                }
            }
        }

        return INSTANCE;
    }

    @Override
    public Observable<MainModel> getWeather(String baseUrl, String weatherId) {
        return RetrofitFactory.getInstance().getWeatherAPi(baseUrl).loadDataByRetrofitRxjava(weatherId);
    }
}
