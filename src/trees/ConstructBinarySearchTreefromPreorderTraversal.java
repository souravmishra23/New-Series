package trees;

public class ConstructBinarySearchTreefromPreorderTraversal {
    public static void main(String[] args) {
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return null;
    }

    public int idx = 0;

    public TreeNode helper(int [] preorder, int leftRange, int rightRange) {
        if (idx < 0  || idx >= preorder.length || preorder[idx] < leftRange || preorder[idx] > rightRange) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx++]);

        root.left = helper(preorder, leftRange, root.val);
        root.right = helper(preorder, root.val, rightRange);

        return root;

    }
}
