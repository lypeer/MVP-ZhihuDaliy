package ${packageName}.framework;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ${packageName}.utils.ActivityController;
<#if useButterKnife>
import butterknife.ButterKnife;
</#if>

public abstract class BaseCustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
        setContentView(getLayoutResId());
        <#if useButterKnife>
        ButterKnife.bind(this);
        </#if>
        initView(savedInstanceState);
    }

    protected abstract void initView(@Nullable Bundle savedInstanceState);



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
