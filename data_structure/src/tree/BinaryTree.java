package tree;

/**
 * 二叉树 递归、前中后序遍历
 * 参考学习【https://zhuanlan.zhihu.com/p/80694144】
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.init();
        System.out.println("先序遍历");
        tree.theFirstTraversal(root);
        System.out.println("");
        System.out.println("中序遍历");
        tree.theInOrderTraversal(root);
        System.out.println("");
        System.out.println("后序遍历");
        tree.thePostOrderTraversal(root);
        System.out.println("");
    }

    /**
     * 初始化数据
     *
     * @return
     */
    public Node init() {
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;
    }

    /**
     * 打印节点数据
     *
     * @param node
     */
    public void printNode(Node node) {
        System.out.print(node.getData());
    }

    /**
     * 先序遍历  根 左 右
     *
     * @param root
     */
    public void theFirstTraversal(Node root) {
        // 先根打印
        printNode(root);
        // 再左节点
        if (root.getLeftNode() != null) {
            theFirstTraversal(root.getLeftNode());
        }
        // 再右节点
        if (root.getRightNode() != null) {
            theFirstTraversal(root.getRightNode());
        }
    }

    /**
     * 中序遍历 左 根 右
     */
    public void theInOrderTraversal(Node root) {
        // 先左节点
        if (root.getLeftNode() != null) {
            theInOrderTraversal(root.getLeftNode());
        }
        // 再根打印
        printNode(root);
        // 再右节点
        if (root.getRightNode() != null) {
            theInOrderTraversal(root.getRightNode());
        }
    }

    /**
     * 后续遍历 左 右 根
     */
    public void thePostOrderTraversal(Node root) {
        // 先左节点
        if (root.getLeftNode() != null) {
            thePostOrderTraversal(root.getLeftNode());
        }
        // 再右节点
        if (root.getRightNode() != null) {
            thePostOrderTraversal(root.getRightNode());
        }
        // 再根打印
        printNode(root);
    }
}
