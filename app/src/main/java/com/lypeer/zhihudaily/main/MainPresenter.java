package com.lypeer.zhihudaily.main;

import android.support.annotation.NonNull;

import com.lypeer.zhihudaily.App;
import com.lypeer.zhihudaily.Constants;
import com.lypeer.zhihudaily.OnResultCallback;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.data.news.LatestNewsRepository;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/4.
 */

public class MainPresenter implements MainContract.Presenter {

    private final LatestNewsRepository mRepository;
    private final MainContract.View mView;

    public MainPresenter(@NonNull LatestNewsRepository repository, @NonNull MainContract.View view) {
        mRepository = repository;
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        loadNews(true);
    }

    @Override
    public void loadNews(boolean isFirstLoad) {
        mView.setLoading(true);
        mRepository.setFirstLoad(isFirstLoad);
        mRepository.loadLatestNews(new OnResultCallback<List<LatestNewsResponse.StoriesBean>>() {
            @Override
            public void onSuccess(List<LatestNewsResponse.StoriesBean> resultValue, int code) {
                if (!mView.isActive()) {
                    return;
                }
                if (code == Constants.ResultCode.LOCAL) {
                    if (null != resultValue) {
                        mView.showNews(resultValue);
                    }
                } else if (code == Constants.ResultCode.REMOTE) {
                    if (null != resultValue) {
                        mView.showNews(resultValue);
                        mView.setLoading(false);
                    } else {
                        mView.showError(App.getAppContext().getString(R.string.error_data_null));
                    }
                }else {
                    mView.showError(App.getAppContext().getString(R.string.error_unknown));
                }
            }

            @Override
            public void onFail(String errorMessage) {
                if (!mView.isActive()) {
                    return;
                }
                mView.showError(null == errorMessage ? App.getAppContext().getString(R.string.error_network) : errorMessage);
            }
        });
    }
}
