package tree;

import java.util.ArrayList;
import java.util.List;

public class BFS {
    public static void main(String[] args) {
        TreeNode<String> tree = InitData.init();
        bfs(tree.getChildList(), 0);
    }

    public static <String> void bfs(List<TreeNode<String>> children, int depth) {
        List<TreeNode<String>> thisChildren, allChildren = new ArrayList<>();
        for (TreeNode<String> child : children) {
            System.out.println(child.getValue() + ", " + depth);
            thisChildren = child.getChildList();
            if (thisChildren != null && thisChildren.size() > 0) {
                allChildren.addAll(thisChildren);
            }
        }
        if (allChildren.size() > 0) {
            bfs(allChildren, depth + 1);
        }
    }

}
