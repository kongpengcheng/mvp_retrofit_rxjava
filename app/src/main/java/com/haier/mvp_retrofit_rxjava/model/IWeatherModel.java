package com.haier.mvp_retrofit_rxjava.model;

import rx.Observable;

/**
 * Created by Harry.Kong on 2016/12/12.
 */

public interface IWeatherModel {
    /**
     * 获取搜食记
     *
     * @param baseUrl
     * @param param   请求参数
     * @return
     */
    Observable<MainModel> getWeather(String baseUrl, String weatherId);
}
