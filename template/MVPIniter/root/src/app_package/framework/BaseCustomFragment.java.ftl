package ${packageName}.framework;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<#if useButterKnife>
import butterknife.ButterKnife;
</#if>

public abstract class BaseCustomFragment extends Fragment {

    protected View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null)
            mRootView = inflater.inflate(getLayoutResId(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        <#if useButterKnife>
        ButterKnife.bind(this, mRootView);
        </#if>
        initView(savedInstanceState);
    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    @LayoutRes
    protected abstract int getLayoutResId();
}
