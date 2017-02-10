package com.lypeer.zhihudaily.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lypeer.zhihudaily.ActivityController;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.main.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lypeer on 2017/2/10.
 */

public abstract class BaseActivity<P> extends AppCompatActivity{

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

    protected abstract P createPresenter();

    /**
     * set resource id
     *
     * @return layout id of current activity
     */
    @LayoutRes
    protected abstract int getLayoutResId();
}
