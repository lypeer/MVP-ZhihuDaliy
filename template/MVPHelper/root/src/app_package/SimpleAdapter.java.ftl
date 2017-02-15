package ${packageName};

import android.content.Context;
import android.view.ViewGroup;

import ${rootName}.framework.BaseAdapter;
import ${rootName}.framework.BaseViewHolder;

public class ${name}Adapter extends BaseAdapter<ItemValueType> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new ${name}VH(context , parent);
    }
}
