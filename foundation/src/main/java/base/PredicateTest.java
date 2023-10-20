package base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author:
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<Integer> list = ThreadLocalRandom.current().ints().limit(10).boxed().collect(Collectors.toList());

        Integer reduce = list.stream().reduce(0, Math::max);
        System.out.println("max = " + reduce);
        Integer reduce1 = list.stream().reduce(Math::max).get();
        System.out.println("max = "+ reduce1);

        List<Integer> evenList = filter(list, i -> i % 2 == 0);
        System.out.println(evenList);
        List<Integer> oddList = filter(list, i -> i % 2 != 0);
        System.out.println(oddList);


        List<Integer> rest = filter(list, Predicate::integerWithSingular);
        System.out.println(rest);


    }

    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
