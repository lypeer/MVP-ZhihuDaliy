package com.lypeer.zhihudaily;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lypeer on 2017/2/5.
 */

public abstract class BaseAdapter <V> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 装载了每个Item的Value的列表
     */
    protected List<V> mValueList;

    /**
     * 我写的一个接口，通过回调分发点击事件
     */
    private OnItemClickListener<V> mOnItemClickListener;

    private ViewGroup mParent;
    private static final int HEADER = 666;

    public boolean isHasHeader() {
        return mHasHeader;
    }

    private boolean mHasHeader = false;
    private boolean mHasFooter = false;
    private BaseViewHolder mHeaderVH;
    private BaseViewHolder mFooterVH;
    private Object mHeaderValue;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mParent = parent;

        if (mHasHeader && viewType == HEADER)
            return mHeaderVH;

        return createViewHolder(parent.getContext(), parent);
    }

    @Override
    public int getItemViewType(int position) {
        if (mHasHeader && position == 0)
            return HEADER;

        return super.getItemViewType(position);
    }

    @Override
    @SuppressWarnings("unchecked")//一定会是BaseViewHolder的子类，因为createViewHolder()的返回值
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder viewHolder = (BaseViewHolder) holder;
        if (mHasHeader) {
            if (position == 0)
                viewHolder.setData(mHeaderValue, position, mOnItemClickListener);
            else
                viewHolder.setData(mValueList.get(position - 1), position - 1, mOnItemClickListener);
        } else
            viewHolder.setData(mValueList.get(position), position, mOnItemClickListener);
    }

    /**
     * 设置每个Item的点击事件
     */
    public void setOnClickListener(OnItemClickListener<V> listener) {
        this.mOnItemClickListener = listener;
    }

    /**
     * 刷新数据
     *
     * @param valueList 新的数据列表
     */
    public void refreshData(List<V> valueList) {
        refreshData(valueList, null);
    }

    public void refreshData(List<V> valueList, Object headerValue) {
        this.mValueList = valueList;
        if (headerValue != null)
            this.mHeaderValue = headerValue;
        notifyDataSetChanged();
    }

    public void addData(List<V> newValueList){
        this.mValueList.addAll(newValueList);
        notifyDataSetChanged();
    }

    /**
     * 设置是否有header
     *
     * @param hasHeader true表示有header，false表示没有
     */
    public void hasHeader(boolean hasHeader) {
        this.mHasHeader = hasHeader;
    }

    public void setHeaderVH(BaseViewHolder headerVH) {
        this.mHeaderVH = headerVH;
    }

    public void setHeaderValue(Object headerValue) {
        this.mHeaderValue = headerValue;
    }

    @Override
    public int getItemCount() {
        int size;
        if (mHasHeader)
            size = mValueList == null ? 1 : mValueList.size() + 1;
        else
            size = mValueList == null ? 0 : mValueList.size();

        return size;
    }

    public ViewGroup getParent() {
        return mParent;
    }

    /**
     * 生成ViewHolder
     */
    protected abstract BaseViewHolder createViewHolder(Context context, ViewGroup parent);
}
