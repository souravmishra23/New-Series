package arrays.subarrays;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int n = nums.length;
        int count = 0;
        int right = 0;
        int left = 0;
        int prod = 1;

        while (right < n) {
            prod *= nums[right];

            if (prod >= k) {
                prod /= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }
}
