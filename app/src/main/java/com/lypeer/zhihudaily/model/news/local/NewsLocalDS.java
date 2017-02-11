package com.lypeer.zhihudaily.model.news.local;

import com.lypeer.zhihudaily.utils.BaseUtil;
import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.model.news.NewsDataSource;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/8.
 */

public class NewsLocalDS implements NewsDataSource {

    private static class SingletonHolder {
        private static final NewsLocalDS INSTANCE = new NewsLocalDS();
    }

    private NewsLocalDS(){}

    public static NewsLocalDS getInstance(){
        return NewsLocalDS.SingletonHolder.INSTANCE;
    }

    @Override
    public void loadLatestNews(OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback) {
        //todo database
        resultCallback.onFail(BaseUtil.getString(R.string.error_data_null));
    }
}
