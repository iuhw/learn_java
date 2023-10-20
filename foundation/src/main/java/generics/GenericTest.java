package generics;

import javafx.util.Builder;

import java.util.function.Supplier;

/**
 * @author:
 */
public class GenericTest {
    public static void main(String[] args) {
        Plate<? extends Fruit> fruitPlate = new Plate<>(new Apple());

//        fruitPlate.set(new GreenApple());
//        fruitPlate.set(new Food());
        Fruit fruit = fruitPlate.get();

        System.out.println(fruit);

        Plate<? super Fruit> plate = new Plate<>(new Fruit());

        plate.set(new Fruit());
//        plate.set(new Apple());
//        plate.set(new Food());
//        plate.set(new Meat());

        Supplier<Meat> meat = Meat::new;
        Meat meat2 = meat.get();
//        Runnable meat3 = Meat::new;
//        meat3.run();
        Builder<Meat> meat4 = Meat::new;
        System.out.println(meat4);
        Meat meat5 = meat4.build();
        System.out.println(meat5);
    }
}
