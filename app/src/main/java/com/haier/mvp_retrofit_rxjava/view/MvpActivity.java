package com.haier.mvp_retrofit_rxjava.view;

import android.os.Bundle;

import com.haier.mvp_retrofit_rxjava.present.BasePresenter;


/**
 * Created by kong
 * 初始化presenter和取消订阅
 */
public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

}
