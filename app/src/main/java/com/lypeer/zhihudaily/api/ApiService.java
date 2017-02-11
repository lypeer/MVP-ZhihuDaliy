package com.lypeer.zhihudaily.api;

import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lypeer on 2017/2/9.
 */

public interface ApiService {

    @GET("news/latest")
    Call<LatestNewsResponse> loadLatestNews();
}
