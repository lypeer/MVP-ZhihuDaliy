package ${packageName};

import android.os.Bundle;
import android.support.annotation.Nullable;

import ${rootName}.framework.BaseFragment;

public class ${name}Fragment extends BaseFragment<${name}Presenter>{
    
    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        
    }

    @Override
    protected ${name}Presenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }
}
