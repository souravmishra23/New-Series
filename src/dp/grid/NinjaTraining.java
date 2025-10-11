package dp.grid;

public class NinjaTraining {
    public static void main(String [] args) {
        int[][] matrix = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };

        System.out.println(ninjaTraining(matrix));
    }

    public static int ninjaTraining(int[][] matrix) {
        int n = matrix[0].length;
        Integer[][] dp = new Integer[n + 1][n + 1];
       //return rec(n, 0, -1, matrix);
        return memo(n, 0, -1, matrix, dp);
    }

    public static int rec(int n, int i, int prev, int [][] matrix) {
        
        if (i >= n) {
            return 0;
        }

        int max = 0;

        for (int j = 0; j < 3; j++) {
            if (j != prev) {
                max = Math.max(max, matrix[i][j] + rec(n, i + 1, j, matrix));
            }
        }

        return max;
    }

    public static int memo(int n, int i, int prev, int [][] matrix, Integer[][] dp) {
        if (i >= n) {
            return 0;
        }

        if (prev != -1 && dp[i][prev] != null) {
            return dp[i][prev];
        }

        int max = 0;

        for (int j = 0; j < 3; j++) {
            if (j != prev) {
                max = Math.max(max, matrix[i][j] + memo(n, i + 1, j, matrix, dp));
            }
        }

        if (prev != -1) {
            dp[i][prev] = max;
        }

        return max;
    }
}
