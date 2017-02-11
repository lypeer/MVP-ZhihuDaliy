package com.lypeer.zhihudaily.feature.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.lypeer.zhihudaily.framework.BaseView;
import com.lypeer.zhihudaily.utils.BaseUtil;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import java.util.List;

import butterknife.BindView;

/**
 * Created by lypeer on 2017/2/4.
 */

public class MainView extends BaseView<MainContract.Presenter> implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_main)
    RecyclerView mRvMain;
    @BindView(R.id.srl_main)
    SwipeRefreshLayout mSrlMain;

    private MainAdapter mAdapter;

    public MainView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        mAdapter = new MainAdapter();
        mRvMain.setItemAnimator(new DefaultItemAnimator());
        mRvMain.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvMain.setAdapter(mAdapter);

        mSrlMain.setOnRefreshListener(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.main_view;
    }

    @Override
    public void setLoading(boolean isShow) {
        if (isShow) {
            mSrlMain.post(new Runnable() {
                @Override
                public void run() {
                    mSrlMain.setRefreshing(true);
                }
            });
        } else {
            mSrlMain.setRefreshing(false);
        }
    }

    @Override
    public void showNews(List<LatestNewsResponse.StoriesBean> latestNews) {
        if (null == latestNews) {
            return;
        }
        mAdapter.refreshData(latestNews);
    }

    @Override
    public void showError(String errorMessage) {
        BaseUtil.showToast(errorMessage);
    }

    @Override
    public void onRefresh() {
        getPresenter().loadNews(false);
    }
}
