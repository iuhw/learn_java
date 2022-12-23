package template;

import java.util.HashMap;
import java.util.Map;

public class RedisCache extends AbstractGetData{

    private Map<String,String> redisCache = new HashMap<>();

    public RedisCache(AbstractSource source) {
        super(source);
    }

    @Override
    public String lookupCache(String key) {
        System.out.println("redis lookup");
        return redisCache.get(key);
    }

    @Override
    public void putDataToCache(String key, String value) {
        System.out.println("redis put");
        redisCache.put(key, value);
    }
}
