package dp.picknotpick;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(findWays(new int[]{1, 2, 5}, 5));
    }

    public static int findWays(int num[], int tar) {
        // Write your code here..
        // return rec(num.length, num, tar);
//        return memo(num.length, num, tar, new Integer[tar + 1]);
        return tab(num, tar);
    }


    public static int rec(int n, int num[], int tar) {
        if (tar == 0) {
            return 1;
        }
        if (tar < 0) {
            return 0;
        }

        int total = 0;
        for (int val : num) {
            total += rec(n, num, tar - val);
        }
        return total;
    }


    public static int memo(int n, int num[], int tar, Integer[] dp) {
        if (tar == 0) {
            return 1;
        }
        if (tar < 0) {
            return 0;
        }
        if (dp[tar] != null) {
            return dp[tar];
        }
        int total = 0;
        for (int val : num) {
            total += memo(n, num, tar - val, dp);
        }
        return dp[tar] = total;
    }

    public static int tab(int[] num, int tar) {
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int t = 1; t <= tar; t++) {
            int total = 0;
            for (int val : num) {
                if (t - val >= 0) {
                    total += dp[t - val];
                }
            }
            dp[t] = total;
        }
        return dp[tar];
    }

}
