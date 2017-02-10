package com.lypeer.zhihudaily;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lypeer on 2017/2/9.
 */

public class RetrofitClient {

    private static final String TAG = "RetrofitClient";

    private static Retrofit.Builder builder = null;

    private RetrofitClient() {
    }

    public static <T> T buildService(Class<T> clz) {
        return getBuilder().build().create(clz);
    }

    public static Retrofit.Builder getBuilder() {
        return getBuilder(Constants.ContentType.JSON);
    }

    public static Retrofit.Builder getBuilder(String contentType) {
        if (TextUtils.isEmpty(contentType)) {
            contentType = Constants.ContentType.JSON;
        }
        final String finalContentType = contentType;
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (null == builder) {
                builder = new Retrofit.Builder();
                builder.baseUrl("http://news-at.zhihu.com/api/4/");
                builder.addConverterFactory(GsonConverterFactory.create());
            }
            OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
            okBuilder.addNetworkInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY));
            okBuilder.addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader(Constants.AppSign.K_CONTENT_TYPE, finalContentType)
                            .build();
                    return chain.proceed(request);
                }
            });

            builder.client(okBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return builder;
    }
}
