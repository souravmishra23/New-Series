package arrays;

public class KadanesAlgo {
    public static void main(String[] args) {
        int [] arr = new int[]{5, 4, 1, 7, 8};

        long max_sum = arr[0];
        long curr_sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curr_sum = Math.max(arr[i], curr_sum + arr[i]);
            max_sum = Math.max(curr_sum, max_sum);
        }

        System.out.println(max_sum);

    }


}
