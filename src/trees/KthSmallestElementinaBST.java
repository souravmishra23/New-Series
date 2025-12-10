package trees;

public class KthSmallestElementinaBST {
    public static void main(String[] args) {
    }

    public int kthSmallest(TreeNode root, int k) {
        return 0;
    }
    int cnt = 0;
    int max = -1;
    public void helper(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        helper(root.left, k);

        cnt++;
        if (cnt == k) {
            max = root.val;
            return;
        }

        helper(root.right, k);
    }
}
