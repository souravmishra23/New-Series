package dp.minmax;

public class FindMaxSubsequenceSum {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] {1, 4 , 2, -10, 10, 5}, 0));
        System.out.println(maxSumMemo(new int[] {1, 4 , 2, -10, 10, 5}, 0, new Integer[6]));
    }


    public static int maxSum(int [] arr, int idx) {

        if (idx >= arr.length) {
            return 0;
        }

        int pick = arr[idx] + maxSum(arr, idx + 2);

        int notPick = maxSum(arr, idx + 1);


        return Math.max(pick, notPick);
    }

    public static int maxSumMemo(int [] arr, int idx, Integer [] dp) {
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int pick = arr[idx] + maxSumMemo(arr, idx + 2, dp);

        int notPick = maxSumMemo(arr, idx + 1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }
}
