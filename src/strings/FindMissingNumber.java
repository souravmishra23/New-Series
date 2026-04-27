package strings;

import java.util.HashSet;
import java.util.Set;

// https://x.com/_Creation22/status/2031672348076896310/photo/1
public class FindMissingNumber {
    public static void main(String[] args) {
        int N = 100;
        String s = "1098253471";
        Set<Integer> set = new HashSet<>();

// figure out max substring length needed
// for N=10 → length 2, for N=100 → length 3, for N=1000 → length 4
        int maxLen = String.valueOf(N).length();

        for (int i = 0; i < s.length(); i++) {
            for (int len = 1; len <= maxLen; len++) {
                if (i + len <= s.length()) {
                    String sub = s.substring(i, i + len);

                    // skip substrings with leading zeros ("09", "098")
                    if (sub.length() > 1 && sub.charAt(0) == '0') continue;

                    int val = Integer.parseInt(sub);
                    if (val >= 1 && val <= N) {
                        set.add(val);
                    }
                }
            }
        }

// find smallest missing
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                System.out.println("Smallest missing: " + i);
                break;
            }
        }
    }


}
