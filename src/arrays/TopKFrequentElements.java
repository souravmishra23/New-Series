package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// https://leetcode.com/problems/top-k-frequent-elements/

// check the constraints for this in question..
public class TopKFrequentElements {
    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,2,2,3,3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println(map);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((a,b) -> (b.getValue().compareTo(a.getValue())));

        int count = 0;
        int i = 0;
        int [] ans = new int[k];
        for (Map.Entry<Integer, Integer> entry: entryList) {
            if (count < k || (entry.getValue().equals(entryList.get(count - 1).getValue()))) {
                ans[i++] = entry.getKey();
                count++;
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(ans));

        return ans;
    }
}
