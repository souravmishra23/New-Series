package dp.knapsack;

public class Knapsack {
    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1, 2, 4, 5}, new int[]{5, 4, 8, 6}, 4, 5));
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//        return rec(0, weight, value, n, maxWeight);
        return memo(0, weight, value, n, maxWeight, new Integer[n + 1][maxWeight + 1]);
    }

    static int rec(int idx, int[] weight, int[] value, int n, int maxWeight) {
        if (idx == n - 1) {
            if (weight[idx] <= maxWeight) {
                return value[idx];
            } else {
                return 0;
            }
        }

        int include = 0;
        if (weight[idx] <= maxWeight) {
            include = value[idx] + rec(idx + 1, weight, value, n, maxWeight - weight[idx]);
        }

        int exclude = rec(idx + 1, weight, value, n, maxWeight);

        return Math.max(include, exclude);
    }

    static int memo(int idx, int[] weight, int[] value, int n, int maxWeight, Integer[][] dp) {
        if (idx == n - 1) {
            if (weight[idx] <= maxWeight) {
                return value[idx];
            } else {
                return 0;
            }
        }

        if (dp[idx][maxWeight] != null) {
            return dp[idx][maxWeight];
        }

        int include = 0;
        if (weight[idx] <= maxWeight) {
            include = value[idx] + memo(idx + 1, weight, value, n, maxWeight - weight[idx], dp);
        }

        int exclude = memo(idx + 1, weight, value, n, maxWeight, dp);

        return dp[idx][maxWeight] = Math.max(include, exclude);
    }

    static int tabulation(int[] weight, int[] value, int n, int maxWeight) {
        int [][] dp = new int[n + 1][maxWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                int exclude = dp[i - 1][w];
                int include = 0;
                if (weight[i - 1] <= w) {
                    include = value[i - 1] + dp[i - 1][w - weight[i - 1]];
                }
                dp[i][w] = Math.max(exclude, include);
            }
        }

        return dp[n][maxWeight];
    }
}
