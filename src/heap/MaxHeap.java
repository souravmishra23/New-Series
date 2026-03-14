package heap;

import java.util.Arrays;

public class MaxHeap {
    public static void main(String[] args) {
        // max heap implementation , where root is greater than its child nodes..
        // heap considering 1 based indexing
        // so left = 2 * i
        // right = 2 * i + 1
        // leaf nodes we get from (n / 2 + 1) n -- size of the heap
        // for 1 based indexing size is arr size minus 1

        int[] arr = new int[8];
        arr[0] = -1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = 5;
        arr[6] = 6;
        arr[7] = 7;
        int n = 7;
        for (int i = 1; i <= n; i++) {
            heapify(arr, i, n);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int [] arr, int i, int n) {
        int largest = i;
        int left = 2 * largest;
        int right = 2 * largest + 1;

        if (left <= n && arr[largest] <= arr[left]) {
            largest = left;
        }
        if (right <= n && arr[largest] <= arr[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest, n);
        }
    }

    private static void swap(int[] arr, int largest, int i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
