package dp.grid;

public class MaximumNonNegativeProductinaMatrix {

    public static int MOD = 1000000007;

    public static void main(String [] args) {

    }


    public static int maxProductPath(int[][] grid) {
        return 0;
    }

    public static int rec(int [][] grid, int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (i >= m || j >= n) {
            return 1;
        }
        int right = rec(grid, m, n, i, j + 1);
        int down = rec(grid, m, n, i + 1, j);
        int product = grid[i][j] * (Math.max(right, down)) % MOD;

        return product;
    }
}
