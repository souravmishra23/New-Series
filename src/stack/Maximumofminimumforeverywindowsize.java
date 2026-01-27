package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Maximumofminimumforeverywindowsize {
    public static void main(String[] args) {
        maxMinWindow(new int[]{1, 2, 3 , 4}, 4);
    }

    public static int[] maxMinWindow(int[] a, int k) {
        // Write your code here
        int [] ans = new int[k];
        int j = 0;
        for (int i = 1; i <= k ;i++) {
            ans[j++] = getMinSlidingWindow(a, i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    private static int getMinSlidingWindow(int[] a, int k) {
        int max = Integer.MIN_VALUE;
        int n = a.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int [] res = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && a[deque.peekLast()] > a[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = a[deque.peekFirst()];
                max = Math.max(max, a[deque.peekFirst()]);
            }
        }
        return max;
    }
}
