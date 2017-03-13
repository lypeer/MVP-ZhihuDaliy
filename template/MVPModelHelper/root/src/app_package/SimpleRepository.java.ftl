package ${packageName};

import android.support.annotation.NonNull;

import ${rootName}.framework.BaseRepository;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ${name}Repository extends BaseRepository implements ${name}DataSource {
    private final ${name}DataSource mLocalDS;
    private final ${name}DataSource mRemoteDS;

    private static Lock sLock = new ReentrantLock();

    private static ${name}Repository INSTANCE = null;
    private boolean mIsFirstLoad;

    private ${name}Repository(@NonNull ${name}DataSource localDS, @NonNull ${name}DataSource remoteDS) {
        mLocalDS = localDS;
        mRemoteDS = remoteDS;
    }

    public static ${name}Repository getInstance(@NonNull ${name}DataSource localDS, @NonNull ${name}DataSource remoteDS) {
        sLock.lock();
        if (null == INSTANCE) {
            INSTANCE = new ${name}Repository(localDS, remoteDS);
        }
        sLock.unlock();

        return INSTANCE;
    }
}
