package com.haier.mvp_retrofit_rxjava.view;

/**
 * Created by Harry.Kong
 * on 2016/10/19.
 */

public interface BaseView {
    /**
     * 发生错误
     *
     * @param e e
     */
    void onFailure(Throwable e);
}
