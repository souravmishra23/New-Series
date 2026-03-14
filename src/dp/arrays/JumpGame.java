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
// O(n) solution
    public int jumpOptimal(int[] nums) {

        int n = nums.length;

        if (n <= 1) {
            return 0;
        }

        if (nums[0] == 0) {
            return -1;
        }

        int currentEnd = 0;
        int farthest = 0;
        int jumps = 0;

        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (currentEnd == i) {
                jumps++;
                currentEnd = farthest;
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
            if (i >= farthest)
                return -1;
        }

        return -1;

    }
}
