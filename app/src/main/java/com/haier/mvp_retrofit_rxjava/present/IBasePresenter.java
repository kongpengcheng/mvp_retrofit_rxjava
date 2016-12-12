
package com.haier.mvp_retrofit_rxjava.present;

import com.haier.mvp_retrofit_rxjava.view.BaseView;

/**
 * BasePresenter 接口
 *
 * @author kong
 *         created at 2016/6/24 13:54
 */
public interface IBasePresenter<V extends BaseView> {

    /**
     * 初始化数据
     *
     * @param baseView
     */
    void attachView(V baseView);

    /**
     * 释放资源
     */
    void detachView();
}
