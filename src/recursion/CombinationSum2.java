package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(candidates, 0, target, new Stack<>(), ans);
        return ans;
    }

    public static void rec(int [] candidates, int idx, int target, Stack<Integer> ds,List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            ds.add(candidates[i]);
            rec(candidates, i + 1, target-candidates[i], ds, ans );
            ds.pop();
        }
    }
}
