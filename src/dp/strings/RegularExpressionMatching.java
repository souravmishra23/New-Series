package dp.strings;

// https://leetcode.com/problems/regular-expression-matching/description/
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*"));
    }

    public static boolean isMatch(String s, String p) {
        return memo(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }

    public static boolean rec(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        if (j >= p.length()) {
            return false;
        }

        boolean isMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // rec(s, p, i, j + 2) dont take any char, rec(s, p, i + 1, j) take the char and
            // keep matching
            return (rec(s, p, i, j + 2) || (isMatch && rec(s, p, i + 1, j)));
        }

        if (isMatch) {
            return rec(s, p, i + 1, j + 1);
        }

        return false;
    }

    public static boolean memo(String s, String p, int i, int j, Boolean[][] dp) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        if (j >= p.length()) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean isMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // rec(s, p, i, j + 2) dont take any char, rec(s, p, i + 1, j) take the char and
            // keep matching
            return dp[i][j] = (memo(s, p, i, j + 2, dp) || (isMatch && memo(s, p, i + 1, j, dp)));
        }

        if (isMatch) {
            return dp[i][j] = memo(s, p, i + 1, j + 1, dp);
        }

        return dp[i][j] = false;
    }

    

}
