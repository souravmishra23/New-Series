package hashmap;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        int n = s.length();

        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while (i < n - 1) {
                flag1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) >= 2) {
                    break;
                } else {

                    int plen = i - j;
                    max = Math.max(max, plen);
                }
            }

            while (j < i) {
                j++;
                flag2 = true;
                char ch = s.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    break;
                }
            }

            if (flag1 == false && flag2 == false) {
                break;
            }

        }

        return max;
    }
}
