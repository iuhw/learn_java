package tree;

import java.util.List;

/**
 * 数据节点
 */
public class TreeNode<V> {
    private V value;
    private List<TreeNode<V>> childList;

    public TreeNode() {
    }

    public TreeNode(V _value) {
        this.value = _value;
    }

    public TreeNode(V value, List<TreeNode<V>> childList) {
        this.value = value;
        this.childList = childList;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public List<TreeNode<V>> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeNode<V>> childList) {
        this.childList = childList;
    }
}
