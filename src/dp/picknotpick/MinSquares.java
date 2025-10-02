package dp.picknotpick;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/get-minimum-squares0538/1
public class MinSquares {
    public static void main(String[] args) {
        System.out.println(minSquares(100));
    }


    public static int minSquares(int n) {
        // Code here
        // return rec(n);
        // return memo(n, new Integer[n + 1]);
        return tab(n);
    }

    public static int rec(int n) {
        if (n == 0) {
            return 0;
        }

        int min = n;

        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + rec(n - (i * i)));
        }

        return min;
    }

    public static int memo(int n, Integer[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        int min = n;

        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + memo(n - (i * i), dp));
        }

        return dp[n] = min;
    }

    public static int tab(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= n; j++) {
                int temp = j * j;
                if (i - temp >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
            }
        }

        return dp[n];
    }

}
