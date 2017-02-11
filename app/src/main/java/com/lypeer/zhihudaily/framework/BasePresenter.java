package com.lypeer.zhihudaily.framework;

import android.support.annotation.NonNull;

/**
 * Init view and repository and bind view and presenter .
 * <p>
 * Created by lypeer on 2017/2/11.
 */
public abstract class BasePresenter<V extends BaseViewApi, M extends BaseRepository> implements BasePresenterApi {

    private final V mView;
    private final M mRepository;

    public BasePresenter(@NonNull M repository, @NonNull V view) {
        mRepository = repository;
        mView = view;
        mView.setPresenter(this);
    }

    protected M getRepository() {
        return mRepository;
    }

    protected V getView() {
        return mView;
    }

}
