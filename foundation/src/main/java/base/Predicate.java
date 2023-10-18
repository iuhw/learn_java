package base;

/**
 * @author:
 */
@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T num);

}
