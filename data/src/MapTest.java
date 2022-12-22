import java.util.HashMap;
import java.util.Map;

/**
 * @author:
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();

        map.put(null, 1);
        map.put("", 2);
//        map.put(null, null);

        System.out.println(map);
        System.out.println(map.get(null));

    }
}
