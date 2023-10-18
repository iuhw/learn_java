import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 */
public class JosefuTest {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(10);

        for (int i = 10; i < 21; i++) {
            list.add(i);
        }

        System.out.println(list);

        System.out.println(list.indexOf(15));
        System.out.println(list.subList(0, list.indexOf(15)));
        System.out.println(list.subList(list.indexOf(12), list.size()));
        System.out.println(list.subList(list.indexOf(12), list.indexOf(20) + 1));
    }


}
