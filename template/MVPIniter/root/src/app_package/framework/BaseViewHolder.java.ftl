package ${packageName}.framework;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import ${packageName}.api.OnItemClickListener;
<#if useButterKnife>
import butterknife.ButterKnife;
</#if>

/**
 * Init view in recyclerview item .
 * Use with {@link BaseAdapter}
 * <p>
 */
public abstract class BaseViewHolder<V> extends RecyclerView.ViewHolder {

    public BaseViewHolder(Context context, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
        <#if useButterKnife>
        ButterKnife.bind(this, itemView);
        </#if>
    }

    public Context getContext() {
        return itemView.getContext();
    }

    /**
     * To let it's child bind data .
     *
     * @param itemValue item value
     * @param position  current item's position
     * @param listener  click thing listener
     */
    protected abstract void bindData(V itemValue, int position, OnItemClickListener listener);

    /**
     * transmit data
     */
    void setData(V itemValue, int position, OnItemClickListener listener) {
        bindData(itemValue, position, listener);
    }
}

