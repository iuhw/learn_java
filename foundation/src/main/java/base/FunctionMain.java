package base;

import java.util.Arrays;

/**
 * @author:
 */
public class FunctionMain {
    public static void main(String[] args) {
        IFunction f = msg -> System.out.println("hello " + msg);
        f.sayHello("functionInterface");

        f.print();

        Arrays.asList(1,2,3).forEach(num -> System.out.println(IFunction.randomInt() + num));


        Car car = Car.create(Car::new);
        Arrays.asList(car).forEach(Car::repair);
//        Arrays.asList(car).forEach(Car::follow);
        Arrays.asList(car).forEach(car::follow);
    }
}
