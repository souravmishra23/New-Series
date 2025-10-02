package dp.hashmap;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String [] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7}, 6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key remainder: value index
        // idea is if there is same remainder of sum found then the difference of elements between them their sum is multiple of k
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (map.containsKey(rem)) {
                int si = map.get(rem);
                int ei = i;
                if (ei - si >= 2) return true;
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}
