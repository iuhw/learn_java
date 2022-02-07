package tree;

/**
 * 深度优先
 * 参考实践【https://www.cnblogs.com/liyao0312/p/11401019.html】
 */
public class DFS {
    public static void main(String[] args) {
        TreeNode<String> tree = InitData.init();
        dfs(tree, 0);
    }

    public static <V> void dfs(TreeNode<String> tree, int depth) {
        if (tree != null) {
            System.out.println(tree.getValue() + ", " + depth);
            if (tree.getChildList() != null && !tree.getChildList().isEmpty()) {
                // 遍历
                for (TreeNode<String> item : tree.getChildList()) {
                    dfs(item, depth + 1);
                }
            }
        }
    }
}
