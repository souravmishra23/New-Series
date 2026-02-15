package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7}, 7);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(candidates, target, 0, ans, new Stack<>());
        System.out.println(ans);
        return ans;
    }

    public static void rec(int[] candidates, int target, int idx, List<List<Integer>> ans, Stack<Integer> ds) {
        if (idx >= candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (candidates[idx] <= target) {
            ds.add(candidates[idx]);
            rec(candidates, target - candidates[idx], idx, ans, ds);
            ds.pop();
        }
        rec(candidates, target, idx + 1, ans, ds);
    }
}
