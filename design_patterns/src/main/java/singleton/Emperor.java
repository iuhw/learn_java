package singleton;

/**
 * @author:
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * 有N个皇帝实例
 */
public class Emperor {
    private static final int maxNumOfEmperor = 2;
    private static final ArrayList<Emperor> emperors = new ArrayList<>(maxNumOfEmperor);
    private static final ArrayList<String> names = new ArrayList<>(maxNumOfEmperor);
    private static int countNumOfEmperor = 0;

    private Emperor() {
    }

    private Emperor(String name) {
        names.add(name);
    }

    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperors.add(new Emperor("皇帝" + i));
        }
    }

    public static Emperor getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperors.get(countNumOfEmperor);
    }

    public void say() {
        System.out.println(names.get(countNumOfEmperor));
    }
}
