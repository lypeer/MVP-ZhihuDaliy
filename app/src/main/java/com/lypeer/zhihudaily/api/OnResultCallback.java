package com.lypeer.zhihudaily.api;

/**
 * Created by lypeer on 2017/2/6.
 */

public interface OnResultCallback<T> {

    void onSuccess(T resultValue, int code);
    void onFail(String errorMessage);
}
