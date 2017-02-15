package ${packageName};

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ${rootName}.framework.BaseActivity;

public class ${name}Activity extends BaseActivity<${name}Presenter> {
    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        
    }

    @NonNull
    @Override
    protected ${name}Presenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }
}
