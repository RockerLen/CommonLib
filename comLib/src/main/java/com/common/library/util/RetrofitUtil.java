package com.common.library.util;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 输出请求日志的Retrofit工具类
 * <p>
 * 引用到的库
 * compileOnly 'com.squareup.retrofit2:retrofit:2.9.0'
 * compileOnly 'com.squareup.retrofit2:converter-gson:2.7.0'
 * compileOnly('com.github.ihsanbal:LoggingInterceptor:3.1.0') {
 * exclude group: 'org.json', module: 'json'
 * }
 */
public class RetrofitUtil {
    private static final String REQUEST_TAG = "COM_REQUEST";
    private static final String RESPONSE_TAG = "COM_RESPONSE";

    private static final boolean IS_LOG = true;
    private static final long CONNECT_TIME_OUT = 30l;

    private static RetrofitUtil instance;
    private static Retrofit retrofit;

    public static RetrofitUtil getInstance(String baseUrl) {
        if (null == instance) {
            synchronized (RetrofitUtil.class) {
                if (null == instance) {
                    instance = new RetrofitUtil(baseUrl);
                }
            }
        }
        return instance;
    }

    private RetrofitUtil(String baseUrl) {

        LoggingInterceptor.Builder build = new LoggingInterceptor.Builder()
                .setLevel(Level.BASIC)
                .log(Platform.WARN)
                .request(REQUEST_TAG)
                .response(RESPONSE_TAG);
        if (!IS_LOG) {
            build.setLevel(Level.NONE);
        }

        addCommonParams(build);
        LoggingInterceptor interceptor = build.build();

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 添加公共请求参数
     *
     * @param build
     */
    private void addCommonParams(LoggingInterceptor.Builder build) {
//        build.addHeader("cityCode", "53")
//                .addQueryParam("moonStatus", "crescent");
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
