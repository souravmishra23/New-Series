package dp.minmax;

import java.util.List;

public class HouseRobber {
    public static void main(String[] args) {

        System.out.println(maxMoneyLooted(new int[]{10, 2, 3, 11}));
        System.out.println(spaceOptimized(List.of( 10, 2, 3, 11)));
    }

    public static int maxMoneyLooted(int[] houses) {
        //Your code goes here

        int n = houses.length;
        if (n == 1) return houses[0];
        int prev2 = 0;
        int prev = houses[0];

        for (int i = 1; i < n; i++) {
            int take = houses[i];
            if (i > 1) take += prev2;
            int nottake = prev;
            int curri = Math.max(take, nottake);
            prev2 = prev;
            prev = curri;
        }

        return prev;
    }

    public static int robTabulation(List<Integer> nums) {
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

    public static int spaceOptimized(List<Integer> nums) {
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
}
