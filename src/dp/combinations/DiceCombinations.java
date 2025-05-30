package dp.combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://cses.fi/problemset/task/1633
public class DiceCombinations {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {

        PrintWriter out = new PrintWriter(System.out);
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        Integer [] dp = new Integer[n];
       // out.println(combinationsMemo(n, 0, dp));
        out.println(combinationsBottomUp(n));
        out.flush();
        out.close();
//        int result = combinations(3, 0);
//        System.out.println(result);
//        int result1 = combinationsMemo(3, 0, new Integer[3]);
//        System.out.println(result1);
    }

    public static int combinations(int n, int sum) {
        if (sum == n) {
            return 1;
        }
        if (sum > n) {
            return 0;
        }

        int totalWays = 0;
        for (int i = 1; i <= 6; i++) {
            totalWays = (totalWays + combinations(n, sum + i)) % MOD;
        }
        return totalWays;
    }

    public static int combinationsMemo(int n, int sum, Integer [] dp) {
        if (sum == n) {
            return 1;
        }
        if (sum > n) {
            return 0;
        }

        if (dp[sum] != null) {
            return dp[sum];
        }

        int totalWays = 0;
        for (int i = 1; i <= 6; i++) {
            totalWays = (totalWays + combinationsMemo(n, sum + i, dp)) % MOD;
        }
        return dp[sum] = totalWays;
    }

    public static int combinationsBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to reach sum 0 (do nothing)

        for (int i = 1; i <= n; i++) {
            for (int dice = 1; dice <= 6; dice++) {
                if (i - dice >= 0) {
                    dp[i] = (dp[i] + dp[i - dice]) % MOD;
                }
            }
        }

        return dp[n];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
