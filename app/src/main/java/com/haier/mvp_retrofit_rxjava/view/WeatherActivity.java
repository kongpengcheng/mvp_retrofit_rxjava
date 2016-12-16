package com.haier.mvp_retrofit_rxjava.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haier.mvp_retrofit_rxjava.R;
import com.haier.mvp_retrofit_rxjava.content.HttpConstant;
import com.haier.mvp_retrofit_rxjava.model.MainModel;
import com.haier.mvp_retrofit_rxjava.present.WeatherPresenterIml;

/**
 * Created by Harry.Kong on 2016/12/12.
 */

public class WeatherActivity extends Activity implements WeatherView, View.OnClickListener {
    private Button button2;
    private TextView text;
    WeatherPresenterIml weatherPresenterIml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        weatherPresenterIml = new WeatherPresenterIml(this);
        weatherPresenterIml.attachView(this);
    }

    @Override
        public void getDataSuccess(MainModel model) {
        text.setText(model.getWeatherinfo().getTemp());
    }


    @Override
    public void onFailure(Throwable e) {

    }

    private void initView() {
        button2 = (Button) findViewById(R.id.button2);
        text = (TextView) findViewById(R.id.text);

        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                weatherPresenterIml.getWeather(HttpConstant.WEATHER_HOST, "101310222");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        weatherPresenterIml.detachView();
    }
}
