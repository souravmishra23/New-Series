package dp.minmax;
// https://www.naukri.com/code360/problems/frog-jump_3621012
public class FrogJump {
    public static void main(String[] args) {
        System.out.println(frogJump(4, new int[] {10, 20, 30, 10}));
    }

    public static int frogJump(int n, int[] heights) {

      // return rec(n, 0, heights);
       // return memo(n, 0, heights, new Integer[n]);
       // return tab(n, 0, heights);
        return spaceOptimized(n, 0, heights);
    }

    public static int rec(int n, int idx, int[] heights) {
        if (idx == n - 1) {
            return 0;
        }
        if (idx > n) {
            return Integer.MAX_VALUE;
        }

        int oneJump = rec(n, idx + 1, heights) + Math.abs(heights[idx] - heights[idx + 1]);
        int twoJump = 0;
        if (idx < n - 2) {
            twoJump = rec(n, idx + 2, heights) + Math.abs(heights[idx] - heights[idx + 2]);
        }

        return Math.min(oneJump, twoJump);
    }

    public static int memo(int n, int idx, int[] heights, Integer [] dp) {
        if (idx == n - 1) {
            return 0;
        }
        if (idx > n) {
            return Integer.MAX_VALUE;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int oneJump = memo(n, idx + 1, heights, dp) + Math.abs(heights[idx] - heights[idx + 1]);
        int twoJump = Integer.MAX_VALUE;
        if (idx < n - 2) {
            twoJump = memo(n, idx + 2, heights, dp) + Math.abs(heights[idx] - heights[idx + 2]);
        }

        return dp[idx] = Math.min(oneJump, twoJump);
    }

    public static int tab(int n, int idx, int[] heights) {
        int [] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int oneJump = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int twoJump = Integer.MAX_VALUE;
            if (i > 1) {
                twoJump = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(oneJump, twoJump);
        }
        return dp[n - 1];
    }

    public static int spaceOptimized(int n, int idx, int[] heights) {
        int prev = 0, prev2 = 0;
        for (int i = 1; i < n; i++) {
            int oneJump = prev + Math.abs(heights[i] - heights[i - 1]);
            int twoJump = Integer.MAX_VALUE;
            if (i > 1) {
                twoJump = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(oneJump, twoJump);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
