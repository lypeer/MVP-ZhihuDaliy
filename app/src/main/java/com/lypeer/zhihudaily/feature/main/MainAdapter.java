package com.lypeer.zhihudaily.feature.main;

import android.content.Context;
import android.view.ViewGroup;

import com.lypeer.zhihudaily.framework.BaseAdapter;
import com.lypeer.zhihudaily.framework.BaseViewHolder;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

/**
 * Created by lypeer on 2017/2/5.
 */

public class MainAdapter extends BaseAdapter<LatestNewsResponse.StoriesBean> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new MainVH(context , parent);
    }
}
