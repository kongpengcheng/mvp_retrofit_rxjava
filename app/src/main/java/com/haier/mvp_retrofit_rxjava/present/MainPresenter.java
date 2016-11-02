package com.haier.mvp_retrofit_rxjava.present;

import com.haier.mvp_retrofit_rxjava.model.MainModel;
import com.haier.mvp_retrofit_rxjava.retrofit.ApiCallback;
import com.haier.mvp_retrofit_rxjava.view.MainView;

/**
 * Created by kong
 * 把接口传过去，供接口的回调
 */
public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        attachView(view);
    }

    public void loadDataByRetrofitRxjava(String cityId) {
        addSubscription(apiStores.loadDataByRetrofitRxjava(cityId),
                new ApiCallback<MainModel>() {
                    @Override
                    public void onSuccess(MainModel model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }


                    @Override
                    public void onFinish() {
                    }

                });
    }

}
