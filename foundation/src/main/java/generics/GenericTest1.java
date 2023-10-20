package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author:
 */
public class GenericTest1 {
    public static void main(String[] args) {
        List<Integer> list1 = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        List<? extends Number> list = new ArrayList<>(list1);
        System.out.println(list.get(1));


        List<? super  Number> nList = new ArrayList<>();
        nList.add(20.0);
        System.out.println(nList.get(0));
    }
}
