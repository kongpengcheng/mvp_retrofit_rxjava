package com.haier.mvp_retrofit_rxjava.retrofit;


import com.haier.mvp_retrofit_rxjava.model.MainModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by kong
 */
public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://www.weather.com.cn/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> loadDataByRetrofitRxjava(@Path("cityId") String cityId);
}
