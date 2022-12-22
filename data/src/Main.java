import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        long a = 32;
        long b = 148;
        BigDecimal r = new BigDecimal((double) a/b);
        r.setScale(4);
        System.out.println(r);
        BigDecimal abd = new BigDecimal(a);
        BigDecimal bbd = new BigDecimal(b);
        System.out.println(abd.divide(bbd,BigDecimal.ROUND_FLOOR));
    }
}