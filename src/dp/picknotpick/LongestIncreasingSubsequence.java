package dp.picknotpick;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {7,7,7,7,7,7,7}));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer [][] dp = new Integer[n + 1][n + 1];
        return memo(nums, 0, -1, dp);
    }

    public static int memo(int [] nums, int idx, int prev, Integer [][] dp) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx][prev + 1] != null) {
            return dp[idx][prev + 1];
        }

        int lenIncluding = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            lenIncluding = 1 + memo(nums, idx + 1, idx, dp);
        }

        int excluding = memo(nums, idx + 1, prev, dp);

        return dp[idx][prev + 1] = Integer.max(lenIncluding, excluding);
    }
}
