package base;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author:
 */
public class Car {

    public static void main(String[] args) {
        Car car = Car.create(Car::new);
        Arrays.asList(car).forEach(Car::repair);
    }

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }



}
