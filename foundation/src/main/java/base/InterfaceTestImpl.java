package base;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author:
 */
public class InterfaceTestImpl implements InterfaceTest{
    @Override
    public void print() {
        System.out.println("impl override method");
    }

    @Override
    public int minNum(Integer... nums) {
        return Arrays.stream(nums).reduce(0,Math::min);
    }

    public static void main(String[] args) {
        InterfaceTest i = new InterfaceTestImpl();
        i.print();
    }
}
