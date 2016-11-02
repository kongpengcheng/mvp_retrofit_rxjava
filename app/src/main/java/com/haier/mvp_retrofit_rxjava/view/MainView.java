package com.haier.mvp_retrofit_rxjava.view;


import com.haier.mvp_retrofit_rxjava.model.MainModel;

/**
 * Created by kong
 */
public interface MainView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFail(String msg);

}
