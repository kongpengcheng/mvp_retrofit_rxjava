package com.haier.mvp_retrofit_rxjava.retrofit;

import com.haier.mvp_retrofit_rxjava.interceptors.HttpLoggingInterceptor;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 普通网络访问
 * Created by Teaphy
 * on 2016/6/24.
 */
public class CustomRetrofit {

    private static CustomRetrofit INSTANCE;

    private CustomRetrofit() {

    }

    public synchronized static CustomRetrofit getInstance() {
        if (null == INSTANCE) {
            synchronized (CustomRetrofit.class) {
                if (null == INSTANCE) {
                    INSTANCE = new CustomRetrofit();
                }
            }
        }
        return INSTANCE;
    }

    public Retrofit getRetrofit(String baseUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
//
//    public Retrofit getRetrofitSSL(String baseUrl, Context context) {
//
//        SSLSocketFactory sslSocketFactory = null;
//        try {
//            sslSocketFactory = getSSLSocketFactory_Certificate(context, "BKS", R.raw.ucloud_cer);
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
//
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .sslSocketFactory(sslSocketFactory)
//                .connectTimeout(5000, TimeUnit.MILLISECONDS)
//                .addInterceptor(interceptor)
//                .build();
//
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(okHttpClient)
//                .build();
//
//        return retrofit;
//    }


    /**
     * 获取SSL证书
     *
     * @param context
     * @param keyStoreType
     * @param keystoreResId
     * @return
     * @throws CertificateException
     * @throws KeyStoreException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
//    private static SSLSocketFactory getSSLSocketFactory_Certificate(Context context, String keyStoreType, int keystoreResId)
//            throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException {
//
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//
//        InputStream caInput = context.getResources().openRawResource(keystoreResId);
//
//        Certificate ca = cf.generateCertificate(caInput);
//
//        caInput.close();
//
//        if (keyStoreType == null || keyStoreType.length() == 0) {
//
//            keyStoreType = KeyStore.getDefaultType();
//
//        }
//
//        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
//
//        keyStore.load(null, null);
//
//        keyStore.setCertificateEntry("ca", ca);
//
//        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
//
//        tmf.init(keyStore);
//
//        TrustManager[] wrappedTrustManagers = getWrappedTrustManagers(tmf.getTrustManagers());
//
//        SSLContext sslContext = SSLContext.getInstance("TLS");
//
//        sslContext.init(null, wrappedTrustManagers, null);
//
//        return sslContext.getSocketFactory();
//
//    }
//
//    private static TrustManager[] getWrappedTrustManagers(TrustManager[] trustManagers) {
//
//        final X509TrustManager originalTrustManager = (X509TrustManager) trustManagers[0];
//
//        return new TrustManager[]{
//
//                new X509TrustManager() {
//
//                    public X509Certificate[] getAcceptedIssuers() {
//
//                        return originalTrustManager.getAcceptedIssuers();
//
//                    }
//
//                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
//
//                        try {
//
//                            originalTrustManager.checkClientTrusted(certs, authType);
//
//                        } catch (CertificateException e) {
//
//                            e.printStackTrace();
//
//                        }
//
//                    }
//
//                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
//
//                        try {
//
//                            originalTrustManager.checkServerTrusted(certs, authType);
//
//                        } catch (CertificateException e) {
//
//                            e.printStackTrace();
//
//                        }
//
//                    }
//
//                }
//
//        };
//
//    }
}
