package com.lypeer.zhihudaily.utils;

/**
 * Class to place the static value .
 * <p>
 * Created by lypeer on 2017/2/9.
 */

public class Constants {

    public static String BASE_URL = "http://news-at.zhihu.com/api/4/";

    public interface ContentType {
        String
                JSON = "application/json",
                PNG = "image/png",
                JPEG = "image/jpeg",
                FROM_DATA = "multipart/form-data";
    }

    public interface AppSign {
        String
                K_CONTENT_TYPE = "Content-Type",
                V_CONTENT_TYPE = "application/json";
    }

    public interface ResultCode {
        int
                LOCAL = 1024,
                REMOTE = 1025;
    }

    public interface LocalKey {
        String
                LATEST_NEWS = "http://news-at.zhihu.com/api/4/news/latest";
    }
}
