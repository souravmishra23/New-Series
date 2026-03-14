package arrays;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/minimize-the-heights-i/1
public class MinimizetheHeights {
    public static void main(String[] args) {
        System.out.println(getMinDiff(new int[]{3, 9, 12, 16, 20}, 3));
    }

    public static int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);

        int n = arr.length;

        int ans = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(smallest, arr[i + 1] - k);
            int max = Math.max(largest, arr[i] + k);

            ans = Math.min(ans, max - min);
        }

        return ans;

    }



}
