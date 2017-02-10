package com.lypeer.zhihudaily.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lypeer.zhihudaily.BaseUtil;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lypeer on 2017/2/4.
 */

public class MainView extends LinearLayout implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_main)
    RecyclerView mRvMain;
    @BindView(R.id.srl_main)
    SwipeRefreshLayout mSrlMain;

    private MainContract.Presenter mPresenter;
    private boolean mActive;
    private Context mContext;

    private MainAdapter mAdapter;

    public MainView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        mContext = context;
        View view = inflate(context, R.layout.main_view, this);
        ButterKnife.bind(this, view);

        mAdapter = new MainAdapter();
        mRvMain.setItemAnimator(new DefaultItemAnimator());
        mRvMain.setLayoutManager(new LinearLayoutManager(mContext));
        mRvMain.setAdapter(mAdapter);

        mSrlMain.setOnRefreshListener(this);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.start();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mActive = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mActive = false;
    }

    @Override
    public boolean isActive() {
        return mActive;
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
        mPresenter.loadNews(false);
    }
}
