package template;

/**
 * 使用模板设计模式实例
 * 既可以扩展数据来源
 * 又可以扩展缓存配置
 */
public abstract class AbstractGetData {

    private AbstractSource source;

    AbstractGetData(AbstractSource source) {
        this.source = source;
    }

    /**
     * 不允许子类覆盖，定义方法模板，就是读缓存 没有就读数据源并设置缓存
     *
     * @param key
     * @return
     */
    protected final String getSetting(String key) {
        // 先读缓存有没有
        String value = lookupCache(key);
        // 没有读数据源
        if (value == null) {
            value = source.read(key);
            // 放置到缓存
            putDataToCache(key, value);
        } else {
            System.out.println("load data from cache " + key);
        }
        return value;
    }

    public abstract String lookupCache(String key);

    public abstract void putDataToCache(String key, String value);
}
