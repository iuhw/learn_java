package base;

/**
 * @author:
 */
@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T num);

    static boolean integerWithSingular(Integer haha) {
        return haha % 2 != 0;
    }

}
