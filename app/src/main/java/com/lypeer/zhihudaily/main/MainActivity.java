package com.lypeer.zhihudaily.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.lypeer.zhihudaily.Injection;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> {

    @BindView(R.id.activity_main)
    LinearLayout mActivityMain;
    @BindView(R.id.view_main)
    MainView mViewMain;

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(
                Injection.provideTasksRepository(),
                mViewMain
        );
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.main_act;
    }
}
