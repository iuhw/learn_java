package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据节点数据初始化
 */
public class InitData {

    /**
     * 数据节点初始化，举例：地区
     *
     * @return
     */
    public static <V> TreeNode<String> init() {
        // 北京
        TreeNode<String> bj = new TreeNode<>("北京");
        // 北京有 东城区、西城区、昌平区等
        TreeNode<String> dcq = new TreeNode<>("东城区");
        TreeNode<String> xcq = new TreeNode<>("西城区");
        TreeNode<String> cyq = new TreeNode<>("朝阳区");
        TreeNode<String> hdq = new TreeNode<>("海淀区");
        TreeNode<String> cpq = new TreeNode<>("昌平区");
        List<TreeNode<String>> cpqChild = new ArrayList<>();
        TreeNode<String> cpz = new TreeNode<>("昌平镇");
        TreeNode<String> nsz = new TreeNode<>("南邵镇");
        cpqChild.add(cpz);
        cpqChild.add(nsz);
        cpq.setChildList(cpqChild);
        List<TreeNode<String>> bjChild = new ArrayList<>();
        bjChild.add(dcq);
        bjChild.add(xcq);
        bjChild.add(cyq);
        bjChild.add(hdq);
        bjChild.add(cpq);
        bj.setChildList(bjChild);

        // 江苏
        TreeNode<String> js = new TreeNode<>("江苏省");
        // 江苏有 南京市、徐州市、苏州市、常州市、连云港市等
        TreeNode<String> njs = new TreeNode<>("南京市");
        TreeNode<String> xzs = new TreeNode<>("徐州市");
        TreeNode<String> szs = new TreeNode<>("苏州市");
        TreeNode<String> czs = new TreeNode<>("常州市");
        TreeNode<String> lygs = new TreeNode<>("连云港市");
        List<TreeNode<String>> lygsChild = new ArrayList<>();
        TreeNode<String> gyx = new TreeNode<>("灌云县");
        lygsChild.add(gyx);
        lygs.setChildList(lygsChild);
        List<TreeNode<String>> jsChild = new ArrayList<>();
        jsChild.add(njs);
        jsChild.add(xzs);
        jsChild.add(szs);
        jsChild.add(czs);
        jsChild.add(lygs);
        js.setChildList(jsChild);

        // 中国
        TreeNode<String> zh = new TreeNode<>("中国");
        List<TreeNode<String>> zhChild = new ArrayList<>();
        zhChild.add(bj);
        zhChild.add(js);
        zh.setChildList(zhChild);

        return zh;
    }
}
