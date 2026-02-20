package dp.arrays;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,0,1,4}));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        Integer [] dp = new Integer[n];

        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int min = Integer.MAX_VALUE;
            for (int j = i; j <= steps && i + j < n; j++) {
                if (dp[i + j] != null) {
                    min = Integer.min(min, dp[i + j]);
                }

                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }

        return dp[0];
    }
}
