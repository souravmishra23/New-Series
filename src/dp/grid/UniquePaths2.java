package dp.grid;

public class UniquePaths2 {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return rec(obstacleGrid, 0, 0);
    }

    public static int rec(int[][] obstacleGrid, int i, int j) {
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 0)
                return 1;
            else
                return 0;
        }

        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) {
            return 0;
        }

        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        return rec(obstacleGrid, i + 1, j) + rec(obstacleGrid, i, j + 1);
    }

    public static int memo(int[][] obstacleGrid, int i, int j, Integer[][] dp) {
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 0)
                return 1;
            else
                return 0;
        }

        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) {
            return 0;
        }

        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = memo(obstacleGrid, i + 1, j, dp) + memo(obstacleGrid, i, j + 1, dp);
    }

    public int tabulation(int grid[][], int m, int n) {
        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
