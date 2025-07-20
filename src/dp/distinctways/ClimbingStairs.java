package dp.distinctways;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(countDistinctWaysToClimbAStair(155));
    }

    public static int countDistinctWaysToClimbAStair(long n) {
       // return rec(0, n);
        return memo(0, n, new Integer[Math.toIntExact(n)]);
    }

    public static int rec(int idx, long n) {
        if (idx == n) {
            return 1;
        }

        if (idx > n) {
            return 0;
        }

        return rec(idx + 1, n) + rec(idx + 2, n);
    }

    public static int memo(int idx, long n, Integer [] dp) {
        if (idx == n) {
            return 1;
        }

        if (idx > n) {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }
        return dp[idx] = rec(idx + 1, n) + rec(idx + 2, n);
    }
}
