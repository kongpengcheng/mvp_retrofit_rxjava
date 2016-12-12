package com.haier.mvp_retrofit_rxjava.present;

import com.haier.mvp_retrofit_rxjava.date.DataManager;
import com.haier.mvp_retrofit_rxjava.view.BaseView;
import rx.subscriptions.CompositeSubscription;

/**
 * BasePresenter
 * @autor kong
 * created at 2016/6/24 13:52
 */
public abstract class BasePresenter<T extends BaseView> implements IBasePresenter<T> {

    private T mView;
    public CompositeSubscription mCompositeSubscription;
    public DataManager mDataManager;
    public boolean isFirstOpen;

    @Override
    public void attachView(T mvpView) {
        this.mView = mvpView;
        this.mCompositeSubscription = new CompositeSubscription();
        this.mDataManager = DataManager.getInstance();
        this.isFirstOpen = true;
    }


    @Override
    public void detachView() {
        this.mView = null;
        this.mCompositeSubscription.unsubscribe();
        this.mCompositeSubscription = null;
        this.mDataManager = null;
    }

    public abstract void loadData(boolean isLoad);

    public boolean isViewAttached() {
        return mView != null;
    }


    public T getBaseView() {
        return mView;
    }


    public void checkViewAttached() {
        if (!isViewAttached()) throw new BaseViewNotAttachedException();
    }

    public boolean isFirstOpen() {
        return isFirstOpen;
    }

    public void setFirstOpen(boolean firstOpen) {
        isFirstOpen = firstOpen;
    }

    public static class BaseViewNotAttachedException extends RuntimeException {
        public BaseViewNotAttachedException() {
            super("Please call IBasePresenter.attachView(IBase) before" +
                    " requesting data to the IBasePresenter");
        }
    }
}
