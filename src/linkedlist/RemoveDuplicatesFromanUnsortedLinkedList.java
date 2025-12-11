package linkedlist;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromanUnsortedLinkedList {
    public static void main(String[] args) {
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> set = new LinkedHashSet<>();

        ListNode curr = head;

        while (curr != null) {
            set.add(curr.val);
        }

        ListNode dummy = new ListNode();

        ListNode temp = dummy;

        for (Integer val: set) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return dummy.next;
        
    }
}
