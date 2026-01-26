package stack;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
