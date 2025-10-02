package dp.grid;

public class MinimumPathSum {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        return rec(grid, 0, 0, grid.length, grid[0].length);
    }

    public static int rec(int[][] grid, int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        int right = rec(grid, i, j + 1, m, n);
        int down = rec(grid, i + 1, j, m, n);

        return grid[i][j] + Math.min(down, right);
    }

    public static int tab(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(up, left) + grid[i][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
