package arrays.cyclic;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
    }
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        if (n == 1 && nums[0] < 0) {
            return 0;
        }

        while (i < n) {
            int j = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < n && nums[i] != nums[j]) {
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
                return k + 1;
            }
            k++;
        }
        return n + 1;
    }
}
