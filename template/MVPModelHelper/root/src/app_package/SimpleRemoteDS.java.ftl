package ${packageName}.remote;

import ${packageName}.${name}DataSource;

public class ${name}RemoteDS implements ${name}DataSource {
    private static class SingletonHolder {
        private static final ${name}RemoteDS INSTANCE = new ${name}RemoteDS();
    }

    private ${name}RemoteDS() {}

    public static ${name}RemoteDS getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
