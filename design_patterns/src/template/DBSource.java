package template;

public class DBSource extends AbstractSource {
    @Override
    String read(String key) {
        System.out.println("read from db");
        return "db " + key;
    }
}
