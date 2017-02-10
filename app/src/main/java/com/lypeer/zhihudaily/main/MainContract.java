package com.lypeer.zhihudaily.main;

import com.lypeer.zhihudaily.BasePresenter;
import com.lypeer.zhihudaily.BaseView;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/4.
 */

public class MainContract {

    interface View extends BaseView<Presenter>{
        void setLoading(boolean isShow);
        void showNews(List<LatestNewsResponse.StoriesBean> latestNews);
        void showError(String errorMessage);
        boolean isActive();
    }

    interface Presenter extends BasePresenter{
        void loadNews(boolean isFirstLoad);
    }
}
