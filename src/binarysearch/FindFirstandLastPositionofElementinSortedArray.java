package binarysearch;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
       
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{};
    }

    public static int search(int[] nums, int target, boolean fIdx) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                ans = mid;
                if (fIdx) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return ans;
    }
}
