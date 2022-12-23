package lsp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:
 */
public class LspClient {
    public static void main(String[] args) {
        father();
        son();
    }

    public static void father() {
        Father f = new Father();
        HashMap map = new HashMap(2);
        f.doSomething(map);
    }

    public static void son() {
        Son s = new Son();
        Map map = new HashMap(2);
        s.doSomething(map);
    }
}
