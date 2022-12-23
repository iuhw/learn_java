package lsp;

import java.util.*;

/**
 * @author:
 */
public class Son extends Father {

    public Collection doSomething(Map map) {
        System.out.println("子类被执行");
        return map.values();
    }

    @Override
    public List doSomething(HashMap map) {
        return new ArrayList(2);
    }
}
