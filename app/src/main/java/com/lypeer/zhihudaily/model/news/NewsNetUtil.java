package com.lypeer.zhihudaily.model.news;

import com.lypeer.zhihudaily.App;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.api.ApiService;
import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.model.RetrofitClient;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;
import com.lypeer.zhihudaily.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lypeer on 2017/2/11.
 */

public class NewsNetUtil {

    public static void loadLatestNews(final OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback) {
        RetrofitClient.buildService(ApiService.class)
                .loadLatestNews()
                .enqueue(new Callback<LatestNewsResponse>() {
                    @Override
                    public void onResponse(Call<LatestNewsResponse> call, Response<LatestNewsResponse> response) {
                        if (null == response || null == response.body()) {
                            resultCallback.onFail(App.getAppContext().getString(R.string.error_not_available));
                            return;
                        }

                        LatestNewsResponse latestNewsResponse = response.body();
                        if (!latestNewsResponse.getStories().isEmpty()) {
                            resultCallback.onSuccess(latestNewsResponse.getStories(), Constants.ResultCode.REMOTE);
                        } else {
                            resultCallback.onFail(App.getAppContext().getString(R.string.error_data_null));
                        }
                    }

                    @Override
                    public void onFailure(Call<LatestNewsResponse> call, Throwable t) {
                        resultCallback.onFail(null == t ? App.getAppContext().getString(R.string.error_network) : t.getMessage());
                    }
                });
    }
}
