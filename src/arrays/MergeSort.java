package arrays;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = new int[] {12, 11, 13, 5, 6, 7};

        mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int [] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int [] arr, int start,  int mid, int end) {
        int n1 = mid - start + 1; // to have mid as well..
        int n2 = end - mid;

        int [] L1 = new int[n1];
        int [] L2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            L1[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            L2[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = start;
        while (i < n1 && j < n2) {
            if (L1[i] <= L2[j]) {
                arr[k] = L1[i++];
            } else {
                arr[k] = L2[j++];
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L1[i++];
            k++;
        }
        while (j < n2) {
            arr[k] = L2[j++];
            k++;
        }
    }
}
