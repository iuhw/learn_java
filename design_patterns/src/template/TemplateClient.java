package template;

public class TemplateClient {
    public static void main(String[] args) {
        AbstractSource file = new FileSource();
        AbstractSource db = new DBSource();
        AbstractGetData local = new LocalCacheData(file);
        System.out.println(local.getSetting("local"));
        System.out.println(local.getSetting("local"));
        AbstractGetData redis = new RedisCache(db);
        System.out.println(redis.getSetting("redis"));
        System.out.println(redis.getSetting("redis"));
    }
}
