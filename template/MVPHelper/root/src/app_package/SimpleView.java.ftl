package ${packageName};

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import ${rootName}.framework.BaseView;

/**
 * Created by lypeer on 2017/2/13.
 */

public class ${name}View extends BaseView<${name}Contract.Presenter> implements ${name}Contract.Presenter {

    public ${name}View(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void start() {

    }

    @Override
    protected void initView(Context context, AttributeSet attrs, int defStyleAttr) {

    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }
}
