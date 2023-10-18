package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author:
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<Double> list = ThreadLocalRandom.current().doubles().limit(10).boxed().collect(Collectors.toList());

        List<Double> evenList = filter(list, i -> i*100 % 2 == 0);
        System.out.println(evenList);
        List<Double> oddList = filter(list, i -> i*100 % 2 != 0);
        System.out.println(oddList);
    }

    public static List<Double>  filter(List<Double> list ,Predicate<Double> predicate){
        List<Double> result =  new ArrayList<>();
        for(Double item:list){
            if(predicate.test(item)){
                result.add(item);
            }
        }
        return result;
    }
}
