package com.lypeer.zhihudaily.framework;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lypeer.zhihudaily.api.OnItemClickListener;

import butterknife.ButterKnife;

/**
 * Init view in recyclerview item .
 * Use with {@link BaseAdapter}
 * <p>
 * Created by lypeer on 2017/2/5.
 */
public abstract class BaseViewHolder<V> extends RecyclerView.ViewHolder {

    public BaseViewHolder(Context context, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
        ButterKnife.bind(this, itemView);
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

