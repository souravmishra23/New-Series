package arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        reverse(nums, 0, len - 1);

        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public static void reverse(int [] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
