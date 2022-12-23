package singleton;

/**
 * @author:
 */
public class Minister {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("第" + i + "个大臣拜见的是:" + emperor);
            emperor.say();
        }
    }
}
