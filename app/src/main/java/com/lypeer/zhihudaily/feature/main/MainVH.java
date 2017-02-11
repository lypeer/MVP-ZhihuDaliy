package com.lypeer.zhihudaily.feature.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lypeer.zhihudaily.utils.BaseUtil;
import com.lypeer.zhihudaily.framework.BaseViewHolder;
import com.lypeer.zhihudaily.api.OnItemClickListener;
import com.lypeer.zhihudaily.R;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import butterknife.BindView;

/**
 * Created by lypeer on 2017/2/6.
 */

public class MainVH extends BaseViewHolder<LatestNewsResponse.StoriesBean> {
    @BindView(R.id.iv_image)
    ImageView mIvImage;
    @BindView(R.id.tv_content)
    TextView mTvContent;

    public MainVH(Context context, ViewGroup root) {
        super(context, root, R.layout.main_item);
    }

    @Override
    protected void bindData(LatestNewsResponse.StoriesBean itemValue, int position, OnItemClickListener listener) {
        if (itemValue.getImages().size() != 0) {
            BaseUtil.load(itemValue.getImages().get(0)).into(mIvImage);
            mIvImage.setVisibility(View.VISIBLE);
        }else {
            mIvImage.setVisibility(View.GONE);
        }

        mTvContent.setText(itemValue.getTitle());
    }
}
