package binarysearch;
/*
 * Lower Bound

The first index where the value is ≥ target.

Upper Bound

The first index where the value is > target.
 */
public class UpperBoundAndLowerBound {
    public static void main(String[] args) {
    }

    public static int lower(int [] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int upper(int [] arr, int target) {
        
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
