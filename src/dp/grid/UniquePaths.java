package dp.grid;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        // return rec(m, n, 0, 0);
        // return memo(m, n, 0, 0, new Integer[m][n]);
        return tab(m, n);
    }

    public static int rec(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        return rec(m, n, i + 1, j) + rec(m, n, i, j + 1);
    }

    public static int memo(int m, int n, int i, int j, Integer[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = memo(m, n, i + 1, j, dp) + memo(m, n, i, j + 1, dp);
    }

    public static int tab(int m, int n) {
        // Create a 2D DP array filled with zeros
        int[][] dp = new int[m][n];

        // Initialize the rightmost column and bottom row to 1
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        // Fill in the DP array bottom-up
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        // Return the result stored in the top-left corner
        return dp[0][0];
    }
}
