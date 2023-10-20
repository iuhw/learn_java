package base;

import java.util.Arrays;

/**
 * @author:
 */
public interface InterfaceTest {
    default void print(){
        System.out.println("default method");
    }

    int minNum(Integer... nums);

    static int max(Integer... nums){
        return Arrays.stream(nums).max(Integer::max).get();
    }
}
