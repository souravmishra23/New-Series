package dp.minmax;

import java.util.Arrays;

public class CutRodIntoSegments {

    public static void main(String[] args) {
        System.out.println(cutSegments(7, 5, 2, 2));
    }

    public static int cutSegments(int n, int x, int y, int z) {
        // Write your code here.
        // return rec(n, x, y, z);
       // return memo(n, x, y, z, new Integer[n + 1]);
        return tab(n, x, y, z);
    }

    public static int rec(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int a = rec(n - x, x, y, z) + 1;
        int b = rec(n - y, x, y, z) + 1;
        int c = rec(n - z, x, y, z) + 1;

        int ans = Math.max(a, Math.max(b, c));

        return ans;
    }

    public static int memo(int n, int x, int y, int z, Integer [] dp) {
        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        int a = memo(n - x, x, y, z, dp) + 1;
        int b = memo(n - y, x, y, z, dp) + 1;
        int c = memo(n - z, x, y, z, dp) + 1;

        int ans = Math.max(a, Math.max(b, c));

        return dp[n] = ans;
    }

    public static int tab(int n, int x, int y, int z) {
        int [] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n ; i++) {
            if (i - x >= 0)
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            if (i - y >= 0)
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            if (i - z >= 0)
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
        }
        return Math.max(dp[n], 0);
    }
}
