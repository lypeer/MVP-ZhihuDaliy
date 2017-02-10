package com.lypeer.zhihudaily.data.news.local;

import com.lypeer.zhihudaily.BaseUtil;
import com.lypeer.zhihudaily.OnResultCallback;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.data.news.LatestNewsDataSource;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/8.
 */

public class LatestNewsLocalDS implements LatestNewsDataSource {

    private static class SingletonHolder {
        private static final LatestNewsLocalDS INSTANCE = new LatestNewsLocalDS();
    }

    private LatestNewsLocalDS(){}

    public static LatestNewsLocalDS getInstance(){
        return LatestNewsLocalDS.SingletonHolder.INSTANCE;
    }

    @Override
    public void loadLatestNews(OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback) {
        //todo database
        resultCallback.onFail(BaseUtil.getString(R.string.error_data_null));
    }
}
