package com.haier.mvp_retrofit_rxjava.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.haier.mvp_retrofit_rxjava.R;
import com.haier.mvp_retrofit_rxjava.model.MainModel;
import com.haier.mvp_retrofit_rxjava.present.MainPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 由Activity/Fragment实现View里方法，包含一个Presenter的引用
 * 实现那个接口代表是这个activty也是接口了，传递过去了
 */
public class MainActivity extends MvpActivity<MainPresenter> implements MainView {

    @Bind(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    MainView mainView = new MainView() {
        @Override
        public void getDataSuccess(MainModel model) {
            Log.d("ceshi", "成功");
            //接口成功回调
            dataSuccess(model);
        }

        @Override
        public void getDataFail(String msg) {

        }
    };

    @Override
    protected MainPresenter createPresenter() {
//这两种写法都可以（一个是activity的实现一个是 点出来的）
        return new MainPresenter(this);
        // return new MainPresenter(mainView);
    }


    @Override
    public void getDataSuccess(MainModel model) {
        Log.d("ceshi", "成功");
        //接口成功回调
        dataSuccess(model);
    }

    @Override
    public void getDataFail(String msg) {
        Log.d("ceshi", "失败" + msg.toString());
    }


    @OnClick({R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button2:
                Log.d("ceshi", "点击了");
                //请求接口
                mvpPresenter.loadDataByRetrofitRxjava("101310222");
                break;
        }
    }

    private void dataSuccess(MainModel model) {
        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData = "青岛" + weatherinfo.getCity()
                + "WD" + weatherinfo.getWD()
                + "WS" + weatherinfo.getWS()
                + "TIME" + weatherinfo.getTime();
        text.setText(showData);
    }
}
