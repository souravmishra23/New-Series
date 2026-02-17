package linkedlist;

public class ReverseNodesinkGroup {
    public static void main(String[] args) {

    }

    ListNode temph = null;
    ListNode tempt = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode originalH = null;
        ListNode originalT = null;
        int len = len(head);
        ListNode curr = head;
        while (len >= k) {
            int tempk = k;
            while (tempk-- > 0) {
                ListNode frwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = frwd;
            }

            if (originalH == null) {
                originalH = temph;
                originalT = tempt;
            } else {
                originalT.next = temph;
                originalT = tempt;
            }
            temph = null;
            tempt = null;
            len -= k;
        }
        originalT.next = curr;
        return originalH;
    }

    public void addFirst(ListNode node) {
        if (temph == null) {
            temph = node;
            tempt = node;
        } else {
            node.next = temph;
            temph = node;
        }
    }

    public int len(ListNode root) {
        ListNode node = root;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
