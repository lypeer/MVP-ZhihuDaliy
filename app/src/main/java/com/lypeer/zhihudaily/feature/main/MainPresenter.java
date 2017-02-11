package com.lypeer.zhihudaily.feature.main;

import android.support.annotation.NonNull;

import com.lypeer.zhihudaily.framework.BasePresenter;
import com.lypeer.zhihudaily.utils.BaseUtil;
import com.lypeer.zhihudaily.utils.Constants;
import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.model.news.NewsRepository;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/4.
 */

public class MainPresenter extends BasePresenter<MainContract.View , NewsRepository> implements MainContract.Presenter {

    public MainPresenter(@NonNull NewsRepository repository, @NonNull MainContract.View view) {
        super(repository, view);
    }

    @Override
    public void start() {
        loadNews(true);
    }

    @Override
    public void loadNews(boolean isFirstLoad) {
        getView().setLoading(true);
        getRepository().setFirstLoad(isFirstLoad);
        getRepository().loadLatestNews(new OnResultCallback<List<LatestNewsResponse.StoriesBean>>() {
            @Override
            public void onSuccess(List<LatestNewsResponse.StoriesBean> resultValue, int code) {
                if (!getView().isActive()) {
                    return;
                }
                if (code == Constants.ResultCode.LOCAL) {
                    if (null != resultValue) {
                        getView().showNews(resultValue);
                    }
                } else if (code == Constants.ResultCode.REMOTE) {
                    if (null != resultValue) {
                        getView().showNews(resultValue);
                        getView().setLoading(false);
                    } else {
                        loadFail(BaseUtil.getString(R.string.error_data_null));
                    }
                }else {
                    loadFail(BaseUtil.getString(R.string.error_unknown));
                }
            }

            @Override
            public void onFail(String errorMessage) {
                if (!getView().isActive()) {
                    return;
                }
                loadFail(null == errorMessage ? BaseUtil.getString(R.string.error_network) : errorMessage);
            }
        });
    }

    @Override
    public void loadFail(String errorMessage) {
        if(!getView().isActive()){
            return;
        }
        getView().showError(errorMessage);
        getView().setLoading(false);
    }
}
