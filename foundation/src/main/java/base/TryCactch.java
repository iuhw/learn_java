package base;

/**
 * @author:
 */
public class TryCactch {
    public static void main(String[] args) {

        System.out.println(false || false || true);

//        String msg = printHello();
//        System.out.println("结果是" + msg);
    }

    private static String printHello() {
        try {
            return "hh" + 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return "发生异常";
        } finally {
            System.out.println("最后执行");
        }
    }
}
