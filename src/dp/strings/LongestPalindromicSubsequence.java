package dp.strings;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    public static int longestPalindromeSubseq(String s) {
        return rec(s, 0, s.length() - 1);
    }

    public static int rec(String s, int i, int j) {
        if (i == j) {
            return 1;
        }

        if (s.charAt(i) == s.charAt(j) && i + 1 == j) {
            return 2;
        }
        int ans = 0;
        if (s.charAt(i) == s.charAt(j)) {
            ans = 2 + rec(s, i + 1, j - 1);
        } else {
            ans = Math.max(rec(s, i + 1, j), rec(s, i, j - 1));
        }

        return ans;
    }

    public static int memo(String s, int i, int j, Integer [][] dp) {
        if (i == j) {
            return 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j) && i + 1 == j) {
            return 2;
        }
        int ans = 0;
        if (s.charAt(i) == s.charAt(j)) {
            ans = 2 + memo(s, i + 1, j - 1, dp);
        } else {
            ans = Math.max(memo(s, i + 1, j, dp), memo(s, i, j - 1, dp));
        }

        return dp[i][j] = ans;
    }
}
