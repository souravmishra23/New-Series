package arrays;

import java.util.Arrays;

public class MoveNegative {
    public static void main(String[] args) {
        int [] arr = new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6};

        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


}
