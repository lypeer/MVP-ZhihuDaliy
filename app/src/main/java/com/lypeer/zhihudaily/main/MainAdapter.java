package com.lypeer.zhihudaily.main;

import android.content.Context;
import android.view.ViewGroup;

import com.lypeer.zhihudaily.BaseAdapter;
import com.lypeer.zhihudaily.BaseViewHolder;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

/**
 * Created by lypeer on 2017/2/5.
 */

public class MainAdapter extends BaseAdapter<LatestNewsResponse.StoriesBean> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new MainVH(context , parent);
    }
}
