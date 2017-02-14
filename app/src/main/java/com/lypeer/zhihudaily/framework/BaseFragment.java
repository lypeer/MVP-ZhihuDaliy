package com.lypeer.zhihudaily.framework;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * All fragment's father .
 * Something is the same with {@link BaseActivity}
 * <p>
 * Created by lypeer on 2017/2/14.
 */
public abstract class BaseFragment<P extends BasePresenterApi> extends Fragment {

    protected View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null)
            mRootView = inflater.inflate(getLayoutResId(), container, false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, mRootView);
        initView(savedInstanceState);
        createPresenter();
    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    protected abstract P createPresenter();

    @LayoutRes
    protected abstract int getLayoutResId();

}
