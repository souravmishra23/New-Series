package dp.strings;

public class MaximumLengthofRepeatedSubarray {
    public static void main(String[] args) {
        System.out.println(findLength(new int[] { 0, 1, 1, 1, 1 }, new int[] { 1, 0, 1, 0, 1 }));
    }

    public static int findLength(int[] nums1, int[] nums2) {
        // return rec(nums1, nums2, 0, 0, 0);
        return tab(nums1, nums2);
    }

    // here lcs wont work since we are not counting the max subsequence here we are
    // calculating the max subarray(which
    // is contigous) so every time there is a mismatch we need to reset the
    // count..and start the count again
    public static int rec(int[] nums1, int[] nums2, int i, int j, int count) {
        if (i >= nums1.length || j >= nums2.length) {
            return count;
        }

        int currentCount = count;
        if (nums1[i] == nums2[j]) {
            currentCount = rec(nums1, nums2, i + 1, j + 1, count + 1);
        }

        int skipA = rec(nums1, nums2, i + 1, j, 0);
        int skipB = rec(nums1, nums2, i, j + 1, 0);

        return Math.max(currentCount, Math.max(skipA, skipB));
    }

    public static int tab(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

}
