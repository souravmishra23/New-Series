package dp.strings;
//https://leetcode.com/problems/wildcard-matching/description/
public class WildcardMatching {
    public static void main(String [] args) {
        System.out.println(isMatch("aa", "*"));
    }

    public static boolean isMatch(String s, String p) {
        return memo(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
        
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

        char pj = p.charAt(j);
        boolean ans;
        if (pj == '*') {
            ans = memo(s, p, i, j + 1, dp) || (i < s.length() && memo(s, p, i + 1, j, dp));
        } else {
            boolean isMatch = (i < s.length()) && (s.charAt(i) == pj || pj == '?' );

            ans = isMatch && memo(s, p, i + 1, j + 1, dp);
        }

        return dp[i][j] = ans;
    }
}
