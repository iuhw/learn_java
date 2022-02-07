package template;

import java.util.HashMap;
import java.util.Map;

public class LocalCacheData extends AbstractGetData {

    private Map<String, String> cache = new HashMap<>();

    public LocalCacheData(AbstractSource source) {
        super(source);
    }

    @Override
    public String lookupCache(String key) {
        return cache.get(key);
    }

    @Override
    public void putDataToCache(String key, String value) {
        cache.put(key, value);
    }
}
