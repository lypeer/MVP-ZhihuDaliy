package com.lypeer.zhihudaily.data.news;

import com.lypeer.zhihudaily.OnResultCallback;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/6.
 */

public interface LatestNewsDataSource {

    void loadLatestNews(OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback);
}
