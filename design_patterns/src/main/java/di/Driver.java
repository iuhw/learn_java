package di;

/**
 * @author:
 */
public class Driver implements IDriver {
    @Override
    public void driver(ICar car) {
        System.out.print("开着");
        car.run();
    }
}
