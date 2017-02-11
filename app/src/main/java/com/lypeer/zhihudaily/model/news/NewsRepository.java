package com.lypeer.zhihudaily.model.news;

import android.support.annotation.NonNull;

import com.lypeer.zhihudaily.api.OnResultCallback;
import com.lypeer.zhihudaily.framework.BaseRepository;
import com.lypeer.zhihudaily.model.news.bean.LatestNewsResponse;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lypeer on 2017/2/6.
 */

public class NewsRepository extends BaseRepository implements NewsDataSource {

    private final NewsDataSource mLocalDS;
    private final NewsDataSource mRemoteDS;

    private static NewsRepository INSTANCE = null;
    private boolean mIsFirstLoad;

    private NewsRepository(@NonNull NewsDataSource localDS, @NonNull NewsDataSource remoteDS) {
        mLocalDS = localDS;
        mRemoteDS = remoteDS;
    }

    public static NewsRepository getInstance(@NonNull NewsDataSource localDS, @NonNull NewsDataSource remoteDS) {
        Lock lock = new ReentrantLock();
        lock.lock();
        if (null == INSTANCE) {
            INSTANCE = new NewsRepository(localDS, remoteDS);
        }
        lock.unlock();

        return INSTANCE;
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
