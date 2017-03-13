package ${packageName}.local;

import ${packageName}.${name}DataSource;

public class ${name}LocalDS implements ${name}DataSource {
    private static class SingletonHolder {
        private static final ${name}LocalDS INSTANCE = new ${name}LocalDS();
    }

    private ${name}LocalDS() {}

    public static ${name}LocalDS getInstance() {
        return ${name}LocalDS.SingletonHolder.INSTANCE;
    }
}
