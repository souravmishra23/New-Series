package dp.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {
        return rec(0, -1, nums);
    }

    public static int rec(int idx, int prevIdx, int[] nums) {
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

    public static int memo(int idx, int prevIdx, int[] nums, Integer[][] dp) {
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

    public static int tab(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        dp[n][n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int previdx = i - 1; previdx >= -1; previdx--) {
                int lenIncluding = 0;
                if (previdx == -1 || nums[i] > nums[previdx]) {
                    lenIncluding = 1 + dp[i + 1][i + 1];
                }
                int lenExculding = dp[i + 1][previdx + 1];
                dp[i][previdx + 1] = Math.max(lenIncluding, lenExculding);
            }
        }

        return dp[0][0];
    }

    public static int spaceOptimized(int [] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int max = Integer.MIN_VALUE;
        for (int val: dp) max = Math.max(val, max);

        return max;
    }

    // dp with binary search ..
    public static int binarySearch(int [] a) {
        int n = a.length;

        List<Integer> ans = new ArrayList<>();
        ans.add(a[0]);

        for (int i = 1; i < n; i++) {
            if (a[i] > ans.get(ans.size() - 1)) {
                ans.add(a[i]);
            } else {
                // Find index of just-bigger element using binary search
                int idx = Collections.binarySearch(ans, a[i]);

                // If not found, binarySearch returns -(insertionPoint) - 1
                if (idx < 0) {
                    idx = -(idx + 1);
                }

                ans.set(idx, a[i]); // Replace with smaller element
            }
        }

        return ans.size();
    }
}
