package com.lypeer.zhihudaily.feature.main;

import com.lypeer.zhihudaily.framework.BasePresenterApi;
import com.lypeer.zhihudaily.framework.BaseViewApi;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/4.
 */

public class MainContract {

    interface View extends BaseViewApi<Presenter>{
        void setLoading(boolean isShow);
        void showNews(List<LatestNewsResponse.StoriesBean> latestNews);
        void showError(String errorMessage);
    }

    interface Presenter extends BasePresenterApi {
        void loadNews(boolean isFirstLoad);
        void loadFail(String errorMessage);
    }
}
