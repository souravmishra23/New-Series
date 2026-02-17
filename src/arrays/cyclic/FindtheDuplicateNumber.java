package arrays.cyclic;

public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }
        int k = 0;
        while (k < n) {
            if (k + 1 != nums[k]) {
                return nums[k];
            }
            k++;
        }
        return -1;
    }
}
