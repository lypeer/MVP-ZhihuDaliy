package com.lypeer.zhihudaily.model.news.remote;

import com.lypeer.zhihudaily.model.news.NewsNetUtil;
import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.model.news.NewsDataSource;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/8.
 */

public class NewsRemoteDS implements NewsDataSource {

    private static class SingletonHolder {
        private static final NewsRemoteDS INSTANCE = new NewsRemoteDS();
    }

    private NewsRemoteDS() {
    }

    public static NewsRemoteDS getInstance() {
        return NewsRemoteDS.SingletonHolder.INSTANCE;
    }

    @Override
    public void loadLatestNews(final OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback) {
        NewsNetUtil.loadLatestNews(resultCallback);
    }
}
