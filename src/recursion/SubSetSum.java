package recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SubSetSum {
    public static void main(String[] args) {
        System.out.println(subsetSums(new int[]{1, 2, 1}));
    }

    public static ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        rec(arr, 0, 0, res);
        System.out.println(res);
        Collections.sort(res);
        return res;

    }

    public static void rec(int [] arr, int idx, int sum, ArrayList<Integer> res) {
        if (idx >= arr.length) {
            res.add(sum);
            return;
        }

        sum += arr[idx];
        rec(arr, idx + 1, sum, res);
        sum -= arr[idx];
        rec(arr, idx + 1, sum, res);

    }
}
