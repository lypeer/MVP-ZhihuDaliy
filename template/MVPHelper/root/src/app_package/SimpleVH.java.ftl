package ${packageName};

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import ${rootName}.utils.BaseUtil;
import ${rootName}.framework.BaseViewHolder;
import ${rootName}.api.OnItemClickListener;
import ${rootName}.R;

import butterknife.BindView;

public class ${name}VH extends BaseViewHolder<ItemValueType> {

    public ${name}VH(Context context, ViewGroup root) {
        super(context, root, layoutId);
    }

    @Override
    protected void bindData(ItemValueType itemValue, int position, OnItemClickListener listener) {
        
    }
}
