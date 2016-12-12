package com.haier.mvp_retrofit_rxjava.present;


/**
 * Created by Harry.Kong on 2016/12/7.
 * 天气的p
 */

public interface WeatherPresenter {
    public void getWeather(String baseUrl, String weatherId);
}
