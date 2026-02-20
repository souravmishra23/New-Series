package arrays;

import java.util.Arrays;

public class MinPlatforms {
    public static void main(String[] args) {
        System.out.println(getMinPlatforms(new int[] { 900, 940, 950, 1100, 1500, 1800 },
                new int[] { 910, 1200, 1120, 1130, 1900, 2000 }, 6));
    }

    static int getMinPlatforms(int[] arr, int[] dep, int n) {
        int result = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else if (arr[i] > dep[j]) {
                platforms--;
                j++;
            }
            if (platforms > result) {
                result = platforms;
            }
        }
        return result;
    }
}
