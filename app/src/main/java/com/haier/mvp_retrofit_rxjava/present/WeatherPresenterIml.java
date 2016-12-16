package com.haier.mvp_retrofit_rxjava.present;

import com.haier.mvp_retrofit_rxjava.model.MainModel;
import com.haier.mvp_retrofit_rxjava.view.WeatherView;

import rx.Subscriber;

/**
 * Created by Harry.Kong on 2016/12/10.
 */

public class WeatherPresenterIml extends BasePresenter<WeatherView> implements WeatherPresenter {
    WeatherView weatherView;

    public WeatherPresenterIml(WeatherView weatherView) {
        this.weatherView = weatherView;
    }

    @Override
    public void loadData(boolean isLoad) {

    }

    @Override
    public void getWeather(String baseUrl, String weatherId) {
        this.mCompositeSubscription.add(mDataManager.getWeather(baseUrl, weatherId)
                .subscribe(new Subscriber<MainModel>() {
                    @Override
                    public void onCompleted() {
                        WeatherPresenterIml.this.mCompositeSubscription.remove(this);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MainModel mainModel) {
                        weatherView.getDataSuccess(mainModel);
                    }
                }));
    }
}
