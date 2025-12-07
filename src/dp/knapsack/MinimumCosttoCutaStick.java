package dp.knapsack;

import java.util.Arrays;

public class MinimumCosttoCutaStick {
    public static void main(String[] args) {




    }


    static int minCost(int n, int[] cuts) {
        Integer [][] dp = new Integer[cuts.length][cuts.length];

        Arrays.sort(cuts);

        return rec(0, n, cuts, 0, cuts.length - 1, dp);

    }

    static int rec(int start_stick, int end_stick, int [] cuts, int left, int right, Integer [][] dp) {
        if (left > right) {
            return 0;
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }
        int cost = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int left_cut = rec(start_stick, cuts[i], cuts, left, i - 1, dp);
            int right_cut = rec(cuts[i], end_stick, cuts, i + 1, right, dp);

            int curr_cost = (end_stick - start_stick) + left_cut + right_cut;
            cost = Math.min(cost, curr_cost);
        }

        return dp[left][right] = cost;

    }
}
