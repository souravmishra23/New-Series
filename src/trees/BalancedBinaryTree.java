package trees;

public class BalancedBinaryTree {
    
    public static void main(String [] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return false;
    }


    public static boolean isBal = true;

    public static int isBal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = isBal(root.left);
        int rh = isBal(root.right);

        if (Math.abs(lh - rh) > 1) {
            isBal = false;
        }

        int th = Math.max(lh, rh) + 1;

        return th;
    }

}
