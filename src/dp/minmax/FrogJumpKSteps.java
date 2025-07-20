package dp.minmax;

public class FrogJumpKSteps {
    public static void main(String[] args) {
        System.out.println(tab(4, 0, new int[]{10, 20, 30, 10}, 2));
    }

    public static int tab(int n, int idx, int[] heights, int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int oneJump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    min = Math.min(oneJump, min);
                }
                dp[i] = min;
            }
        }
        return dp[n - 1];
    }
}
