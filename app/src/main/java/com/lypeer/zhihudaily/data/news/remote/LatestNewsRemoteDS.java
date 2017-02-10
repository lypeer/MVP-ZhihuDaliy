package com.lypeer.zhihudaily.data.news.remote;

import com.lypeer.zhihudaily.ApiService;
import com.lypeer.zhihudaily.App;
import com.lypeer.zhihudaily.Constants;
import com.lypeer.zhihudaily.OnResultCallback;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.RetrofitClient;
import com.lypeer.zhihudaily.data.news.LatestNewsDataSource;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lypeer on 2017/2/8.
 */

public class LatestNewsRemoteDS implements LatestNewsDataSource {

    private static class SingletonHolder {
        private static final LatestNewsRemoteDS INSTANCE = new LatestNewsRemoteDS();
    }

    private LatestNewsRemoteDS() {
    }

    public static LatestNewsRemoteDS getInstance() {
        return LatestNewsRemoteDS.SingletonHolder.INSTANCE;
    }

    @Override
    public void loadLatestNews(final OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback) {
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
