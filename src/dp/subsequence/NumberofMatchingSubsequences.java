package dp.subsequence;
import java.util.*;
public class NumberofMatchingSubsequences {
    public static void main(String[] args) {
        numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"});
    }

    public static int numMatchingSubseq(String s, String[] words) {
        List<String> subs = new ArrayList<>();
        getSubSequences(s, 0, "", subs);
        System.out.println(subs);
        int count = 0;
        for (String str: words) {
            if (subs.contains(str)) {
                count++;
            }
        }
        System.out.println(count);
        return 0;
    }

    public int numMatchingSubseqMapSolution(String superString, String[] words) {
        int matchingSubSequences = 0, m = superString.length();
        HashMap<String, Integer> frequencyOfWords = new HashMap<>();
        for (String word : words)
            frequencyOfWords.put(word, frequencyOfWords.getOrDefault(word, 0) + 1);

        //Now use the same method used in the question isSubSequence?
        for (String subSequence : frequencyOfWords.keySet()) {
            int i = 0, j = 0, n = subSequence.length();
            while (i < m && j < n) {
                if (superString.charAt(i) == subSequence.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == n)
                matchingSubSequences += frequencyOfWords.get(subSequence);
        }
        return matchingSubSequences;
    }

    public static void getSubSequences(String str, int idx, String temp, List<String> subs) {
        if (idx >= str.length()) {
            subs.add(temp);
            return;
        }

        getSubSequences(str, idx + 1, temp + str.charAt(idx), subs);
        getSubSequences(str, idx + 1, temp, subs);
    }

}
