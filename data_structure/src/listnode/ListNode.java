package listnode;

/**
 * @author:
 */
public class ListNode {
    /**
     * 值
     */
    public Integer val;
    /**
     * 指针
     */
    public ListNode next;

    ListNode() {
    }

    ListNode(Integer val) {
        this.val = val;
    }

    ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
