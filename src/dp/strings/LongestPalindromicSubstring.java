package dp.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        longestPalindrome("cbbd");
    }

    public static String longestPalindrome(String s) {
        bruteForce(s);
        return "";

    }


    // O(n2)
    public static String orbitExpansion(String s) {
        String res = "";
        int len = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            // odd length
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l -= 1;
                r += 1;
            }
            // even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l -= 1;
                r += 1;
            }

        }
        return res;
    }


    public static String bruteForce(String s) {
        Set<String> allSubstr = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j + 1);
                if (isPalindrome(subStr)) {
                    allSubstr.add(subStr);
                }
            }
        }
        System.out.println(allSubstr);
        int max = Integer.MIN_VALUE;
        String maxSubstr = "";
        for (String str: allSubstr) {
            max = Math.max(max, str.length());
            if (str.length() > maxSubstr.length()) {
                maxSubstr = str;
            }
        }
        System.out.println(max);
        System.out.println(maxSubstr);
        return "";
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
