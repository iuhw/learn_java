package template;

public class FileSource extends AbstractSource {
    @Override
    String read(String key) {
        System.out.println("read from file");
        return "file " + key;
    }
}
