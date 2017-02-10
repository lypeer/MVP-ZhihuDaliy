package com.lypeer.zhihudaily;

import com.lypeer.zhihudaily.data.news.LatestNewsRepository;
import com.lypeer.zhihudaily.data.news.local.LatestNewsLocalDS;
import com.lypeer.zhihudaily.data.news.remote.LatestNewsRemoteDS;

/**
 * Created by lypeer on 2017/2/9.
 */

public class Injection {

    public static LatestNewsRepository provideTasksRepository() {
        return LatestNewsRepository.getInstance(
                LatestNewsLocalDS.getInstance(),
                LatestNewsRemoteDS.getInstance()
        );
    }
}
