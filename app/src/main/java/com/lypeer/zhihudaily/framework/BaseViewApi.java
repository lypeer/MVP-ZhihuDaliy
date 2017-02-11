package com.lypeer.zhihudaily.framework;

import com.lypeer.zhihudaily.framework.BasePresenterApi;

/**
 * Created by lypeer on 2017/2/4.
 */

public interface BaseViewApi<T extends BasePresenterApi> {

    void setPresenter(T presenter);
    
    boolean isActive();
}