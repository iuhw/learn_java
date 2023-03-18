import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;

public class XhelloClassLoader extends ClassLoader {
    private static String readFile = "/Users/wh/mydev/workspace/IdeaProjects/solidfoundationjava/src/com/wh/classloader/Hello.xlass";
    private static String outputFile = "/Users/wh/mydev/workspace/IdeaProjects/solidfoundationjava/src/com/wh/classloader/out/Hello.class";

    public static void main(String[] args) {
        readFileBytes();
        try {
            Class hello = new XhelloClassLoader().findClass("Hello");
            for (Method method : hello.getDeclaredMethods()) {
                System.out.println(hello.getSimpleName() + "." + method.getName());
            }

            Object object = hello.newInstance();
            Method method = hello.getMethod("hello");
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String base64 = "yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABYMABcAGAEAE0hlbGxvLCBjbGFzc0xvYWRlciEHABkMABoAGwEABUhlbGxvAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACAABAAkAAAAdAAEAAQAAAAUqtwABsQAAAAEACgAAAAYAAQAAAAEAAQALAAgAAQAJAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABAAIAAUAAQAMAAAAAgAN";
        byte[] bytes = Base64.getDecoder().decode(base64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    static void readFileBytes() {
        FileOutputStream fos = null;
        try {
            File inFile = new File(readFile);
            fos = new FileOutputStream(outputFile);

            byte[] readBytes = Files.readAllBytes(inFile.toPath());

            for (int i = 0; i < readBytes.length; i++) {
                readBytes[i] = (byte) (255 - readBytes[i]);
            }

            fos.write(readBytes);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
