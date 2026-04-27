package arrays;

public class CountInversions {
    public static void main(String[] args) {
        int [] arr = new int[]{10, 10, 10};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (n > arr[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static long mergeSort(long[] arr, int left, int right) {

        long count = 0;

        if (left < right) {

            int mid = (left + right) / 2;

            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);

            count += merge(arr, left, mid, right);
        }

        return count;
    }

    static long merge(long[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        long[] L = new long[n1];
        long[] R = new long[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        long count = 0;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {

                arr[k++] = R[j++];

                count += (n1 - i);   // inversion
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];

        return count;
    }
}
