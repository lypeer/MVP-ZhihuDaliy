package com.lypeer.zhihudaily.data.news;

import android.support.annotation.NonNull;

import com.lypeer.zhihudaily.OnResultCallback;
import com.lypeer.zhihudaily.data.news.bean.LatestNewsResponse;

import java.util.List;

/**
 * Created by lypeer on 2017/2/6.
 */

public class LatestNewsRepository implements LatestNewsDataSource {

    private final LatestNewsDataSource mLocalDS;
    private final LatestNewsDataSource mRemoteDS;

    private static LatestNewsRepository INSTANCE = null;
    private boolean mIsFirstLoad;

    private LatestNewsRepository(@NonNull LatestNewsDataSource localDS, @NonNull LatestNewsDataSource remoteDS) {
        mLocalDS = localDS;
        mRemoteDS = remoteDS;
    }

    public static LatestNewsRepository getInstance(@NonNull LatestNewsDataSource localDS, @NonNull LatestNewsDataSource remoteDS) {
        if (null != INSTANCE) {
            return INSTANCE;
        }
        return new LatestNewsRepository(localDS, remoteDS);
    }

    @Override
    public void loadLatestNews(final OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback) {
        if (mIsFirstLoad) {
            mLocalDS.loadLatestNews(new OnResultCallback<List<LatestNewsResponse.StoriesBean>>() {
                @Override
                public void onSuccess(List<LatestNewsResponse.StoriesBean> resultValue, int code) {
                    resultCallback.onSuccess(resultValue, code);
                    loadLatestNewsFromRemoteDS(resultCallback);
                }

                @Override
                public void onFail(String errorMessage) {
                    loadLatestNewsFromRemoteDS(resultCallback);
                }
            });
        } else {
            loadLatestNewsFromRemoteDS(resultCallback);
        }
    }

    private void loadLatestNewsFromRemoteDS(final OnResultCallback<List<LatestNewsResponse.StoriesBean>> resultCallback) {
        mRemoteDS.loadLatestNews(resultCallback);
    }

    public void setFirstLoad(boolean isFirstLoad) {
        mIsFirstLoad = isFirstLoad;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
