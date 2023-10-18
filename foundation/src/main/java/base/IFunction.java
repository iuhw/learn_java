package base;

import java.util.Random;

/**
 * @author:
 */
@FunctionalInterface
public interface IFunction {
    /**
     * 函数式接口有且仅有一个抽象方法
     */
    void sayHello(String msg);

    boolean equals(Object msg);

    /**
     * 默认方法
     */
    default void print() {
        System.out.println("我是一个函数式接口");
    }


    /**
     * 静态方法
     */
    static int randomInt() {
        return new Random().nextInt();
    }
}
