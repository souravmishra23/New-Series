package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
    public static void main(String[] args) {
        suggestedProducts(new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" }, "mouse");
        suggestedProducts(new String[] { "havana" }, "havana");
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 0; i < searchWord.length(); i++) {
            String subStr = searchWord.substring(0, i + 1);

            List<String> result = Arrays.stream(products)
                    .filter(s -> s.startsWith(subStr))
                    .limit(3)
                    .toList();
            ans.add(result);
        }

        System.out.println(ans);
        return ans;
    }

    // 2 ptr approach.. if prefix matches in the left and in the right word then all
    // the middle words also match since its sorted
    public static List<List<String>> suggestedProductsTwoPointer(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products); // sort lexicographically

        int l = 0, r = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);

            // shrink from left: remove strings that don't match at position i
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != ch)) {
                l++;
            }

            // shrink from right
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != ch)) {
                r--;
            }

            // now all valid products are in range [l, r]
            List<String> suggestions = new ArrayList<>();
            int maxToTake = Math.min(3, r - l + 1);

            for (int j = 0; j < maxToTake; j++) {
                suggestions.add(products[l + j]);
            }

            ans.add(suggestions);
        }

        return ans;
    }
}
