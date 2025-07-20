package dp.minmax;

import java.util.ArrayList;

public class MaxNonAdjacentSum {
    public static void main(String[] args) {
        System.out.println(rec(0, 4, new int[]{2, 1, 4, 9}));
        System.out.println(iterative(0, 4, new int[]{2, 1, 4, 9}));
        System.out.println(memo(0, 4, new int[]{2, 1, 4, 9}, new Integer[4]));
    }

    public static int rec(int idx, int n, int[] arr) {
        if (idx >= n) {
            return 0;
        }
        if (idx == n - 1) {
            return arr[idx];
        }

        int include = arr[idx] + rec(idx + 2, n, arr);
        int exclude = rec(idx + 1, n, arr);

        return Math.max(include, exclude);
    }


    public static int memo(int idx, int n, int[] arr, Integer[] dp) {
        if (idx >= n) {
            return 0;
        }
        if (idx == n - 1) {
            return arr[idx];
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int include = arr[idx] + memo(idx + 2, n, arr, dp);
        int exclude = memo(idx + 1, n, arr, dp);

        return dp[idx] = Math.max(include, exclude);
    }

    public static int robTabulation(ArrayList<Integer> nums) {
        int n = nums.size();
        Integer[] dp = new Integer[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int includeAns = nums.get(i) + (i + 2 > n ? 0 : dp[i + 2]);
            int excludeAns = dp[i + 1];
            dp[i] = Math.max(includeAns, excludeAns);
        }
        return dp[0];
    }

    public static int spaceOptimized(ArrayList<Integer> nums) {
        int n = nums.size();
        int prev2 = 0;
        int prev = nums.get(0);
        for (int i = 1; i < n; i++) {
            int take = nums.get(i);
            if (i > 1) take += prev2;
            int nottake = prev;
            int curri = Math.max(take, nottake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }

    // this wont work since elements are not alternative it can be any element just it should not be adjacent
    public static int iterative(int idx, int n, int[] arr) {
       int firstMax = 0;
       int secondMax = 0;

        for (int i = 0; i < n; i += 2) {
            firstMax += arr[i];
        }

        for (int i = 1; i < n; i += 2) {
            secondMax += arr[i];
        }
        return Math.max(firstMax, secondMax);
    }

}
