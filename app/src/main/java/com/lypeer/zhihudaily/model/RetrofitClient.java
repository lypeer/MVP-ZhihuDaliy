package com.lypeer.zhihudaily.model;

import android.text.TextUtils;

import com.lypeer.zhihudaily.utils.Constants;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * To encapsulate the retrofit .
 *
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

    /**
     * Do some job such as bind base url , add network interceptor and sign .
     * Normal request can use {@link #buildService} .
     *
     * @param contentType contentType of this request
     * @return Retrofit.Builder
     */
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
                builder.baseUrl(Constants.BASE_URL);
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
