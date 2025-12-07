package dp.knapsack;

public class Unboundedknapsack {
    public static void main(String[] args) {
       System.out.println(knapsack(new int[]{2, 4, 6}, new int[]{5, 11, 13}, 3, 10));
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return rec(0, weight, value, n, maxWeight);
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
            include = value[idx] + rec(idx, weight, value, n, maxWeight - weight[idx]);
        }

        int exclude = rec(idx + 1, weight, value, n, maxWeight);

        return Math.max(include, exclude);
    }

}
