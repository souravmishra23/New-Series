package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/?envType=problem-list-v2&envId=7p5x763
public class AllNodesDistanceKinBinaryTree {
    public static void main(String [] args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();

            if (top.left != null) {
                parentMap.put(top.left.val, top);
                queue.offer(top.left);
            }

            if (top.right != null) {
                parentMap.put(top.right.val, top);
                queue.offer(top.right);
            }

        }

        Map<Integer, Integer> visited = new HashMap<>();
        queue.offer(target);

        while (k > 0 && !queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0 ; i < size; i++) {
                TreeNode top = queue.poll();

                if (top.left != null && !visited.containsKey(top.left.val)) {
                    queue.offer(top.left);
                }

                if (top.right != null && !visited.containsKey(top.right.val)) {
                    queue.offer(top.right);
                }

                if (parentMap.containsKey(top.val) && !visited.containsKey(parentMap.get(top.val).val)) {
                    queue.offer(parentMap.get(top.val));
                }
            }
            k--;
        }
        
        
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }


}
