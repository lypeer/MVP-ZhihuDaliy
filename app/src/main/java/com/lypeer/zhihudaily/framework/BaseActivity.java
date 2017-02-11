package com.lypeer.zhihudaily.framework;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lypeer.zhihudaily.utils.ActivityController;

import butterknife.ButterKnife;

/**
 * This is BaseActivity .
 * It's responsibility is to make contact between View layer and Presenter layer .
 *
 * Created by lypeer on 2017/2/10.
 */
public abstract class BaseActivity<P extends BasePresenterApi> extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initView(savedInstanceState);
        createPresenter();
    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    /**
     * create a Presenter.
     *
     * @return Presenter of this Activity's View layer
     */
    @NonNull
    protected abstract P createPresenter();

    /**
     * set resource id
     *
     * @return layout id of current activity
     */
    @LayoutRes
    protected abstract int getLayoutResId();

    @Override
    protected void onDestroy() {
        ActivityController.removeActivity(this);
        super.onDestroy();
    }
}
