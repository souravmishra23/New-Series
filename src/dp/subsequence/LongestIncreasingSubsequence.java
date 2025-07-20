package dp.subsequence;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        return rec(0, -1, nums);
    }

    public static int rec(int idx, int prevIdx, int [] nums) {
        if (idx >= nums.length) {
            return 0;
        }

        int lenIncluding = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            lenIncluding = 1 + rec(idx + 1, idx, nums);
        }
        int lenExcluding = rec(idx + 1, idx, nums);

        int max = Math.max(lenIncluding, lenExcluding);

        return max;
    }

    public static int memo(int idx, int prevIdx, int [] nums, Integer [][] dp) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx][prevIdx + 1] != null) {
            return dp[idx][prevIdx + 1];
        }
        int lenIncluding = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            lenIncluding = 1 + memo(idx + 1, idx, nums, dp);
        }
        int lenExcluding = memo(idx + 1, prevIdx, nums, dp);

        int max = Math.max(lenIncluding, lenExcluding);

        return dp[idx][prevIdx + 1] = max;
    }
    
    public static int tab(int [] nums) {
        int n = nums.length;
        int [][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            for (int prevIdx = i - 1; prevIdx >= -1 ; prevIdx--) {
                int lenIncluding = 0;
                if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
                    lenIncluding = 1 + dp[i + 1][i + 1];
                }
                int lenExcluding = dp[i + 1][prevIdx + 1];
                dp[i][prevIdx + 1] = Math.max(lenIncluding, lenExcluding);
            }
        }
        return dp[0][0];
    }
}
