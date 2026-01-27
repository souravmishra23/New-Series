package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static void main(String[] args) {
        subsetsWithDup(new int[]{1,2,2});
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        rec(nums, 0, new ArrayList<>(), ans);
        System.out.println(ans);
        return ans;
    }

    public static void rec(int[] nums, int idx, List<Integer> res, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(res));


        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) continue;
            res.add(nums[i]);
            rec(nums, i + 1, res, ans);
            res.remove(res.size() - 1);
        }
    }
}
