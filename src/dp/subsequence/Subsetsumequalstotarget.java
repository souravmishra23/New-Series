package dp.subsequence;

public class Subsetsumequalstotarget {
    public static void main(String[] args) {

        System.out.println(isSubsetSum(new int[] { 1, 2, 7, 3 }, 6));

    }

    public static boolean isSubsetSum(int[] arr, int target) {

        return rec(arr, target, 0);
    }

    public static boolean rec(int[] arr, int target, int i) {
        // Bases
        if (target == 0)
            return true; // formed the sum
        if (i == arr.length)
            return false; // no items left

        // Exclude current element
        boolean exclude = rec(arr, target, i + 1);

        // Include current element if it fits
        boolean include = false;
        if (arr[i] <= target) {
            include = rec(arr, target - arr[i], i + 1);
        }

        return include || exclude;
    }
}
