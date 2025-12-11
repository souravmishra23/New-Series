package linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode curr = head;

        int sum = 0;
        int carry = 0;

        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int netSum = sum + carry;
            sum = netSum % 10;
            carry = netSum / 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
        }

        if (carry > 0)
            curr.next = new ListNode(carry);
        return head.next;
    }
}
