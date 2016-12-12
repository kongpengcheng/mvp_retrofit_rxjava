
package com.haier.mvp_retrofit_rxjava.retrofit;

/**
 * Retrofit 工厂类
 * RetrofitFactory
 * @author Teaphy
 * created at 2016/6/24 19:09
 */
public class RetrofitFactory {

    private static RetrofitFactory ourInstance;

    private RetrofitFactory() {
        CustomRetrofit.getInstance();
      //  DownloadFileRetrofit.getInstance();
    }

    public synchronized static RetrofitFactory getInstance() {
        if (null == ourInstance) {
            synchronized (RetrofitFactory.class) {
                if (ourInstance == null) {
                    ourInstance = new RetrofitFactory();
                }

            }
        }

        return ourInstance;
    }

    /**
     * 普通网络访问(包括上传图片)Retrofit
     * @param baseUrl url
     * @return
     */
    public ApiStores getWeatherAPi(String baseUrl) {
        return CustomRetrofit.getInstance().getRetrofit(baseUrl).create(ApiStores.class);
    }

    /**
     * openAPI-https请求需要SSL证书
     * @param baseUrl
     * @return
     */
//    public HaierApi getCustomHaierSSLAPi(String baseUrl, Context context) {
//        return CustomRetrofit.getInstance().getRetrofitSSL(baseUrl,context).create(HaierApi.class);
//    }

    /**
     * 下载文件Retrofit
     * @param baseUrl
     * @param responseListener
     * @return
     */
//    public HaierApi getDwonloadHaierAPi(String baseUrl, ProgressResponseBody.ProgressResponseListener responseListener) {
//        return DownloadFileRetrofit.getInstance().getRetrofit(baseUrl, responseListener).create(HaierApi.class);
//    }
}
