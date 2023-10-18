package listnode;

/**
 * @author:
 */
public class ListNodeTest {

    static ListNode data;

    public static void main(String[] args) {

        ListNode data = init();

        show(data);

        // 反转链表
        ListNode reverseNode = reverse(data);

        show(reverseNode);
    }

    static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    static ListNode init() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        return n1;
    }

    static void show(ListNode node) {
        ListNode head = new ListNode(-1, node);
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            System.out.print(p.val + ",");
        }
        System.out.println();
    }
}
