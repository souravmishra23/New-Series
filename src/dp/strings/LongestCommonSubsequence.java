package dp.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "def"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        return rec(text1, text2, 0, 0);
    }

    public static int rec(String s1, String s2, int i, int j) {

        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + rec(s1, s2, i + 1, j + 1);
        } else {
            return Math.max(rec(s1, s2, i + 1, j), rec(s1, s2, i, j + 1));
        }
    }

    public static int helperDp(String s1, String s2, int i, int j, int[][] dp) {

        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + helperDp(s1, s2, i + 1, j + 1, dp);
        } else {
            ans = Math.max(helperDp(s1, s2, i + 1, j, dp), helperDp(s1, s2, i, j + 1, dp));
        }
        dp[i][j] = ans;
        return ans;
    }

    public static int tab(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        dp[s1.length() - 1][s2.length() - 1] = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (s1.charAt(i) == s2.charAt(j)) {
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    ans = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}
