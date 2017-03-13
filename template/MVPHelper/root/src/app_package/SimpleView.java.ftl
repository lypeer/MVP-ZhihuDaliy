package ${packageName};

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
<#if hasAdapterAndVH>
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
</#if>
import android.util.AttributeSet;

import ${rootName}.framework.BaseView;

public class ${name}View extends BaseView<${name}Contract.Presenter> implements ${name}Contract.View {

    <#if hasAdapterAndVH>
    private ${name}Adapter mAdapter;
    </#if>

    public ${name}View(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView(Context context, AttributeSet attrs, int defStyleAttr) {
    <#if hasAdapterAndVH>
    mAdapter = new ${name}Adapter();
    mRvXXX.setItemAnimator(new DefaultItemAnimator());
    mRvXXX.setLayoutManager(new LinearLayoutManager(getContext()));
    mRvXXX.setAdapter(mAdapter);
    </#if>
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }
}
