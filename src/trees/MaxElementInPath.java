package trees;

public class MaxElementInPath {
    public static void main(String[] args) {

    }

    public static int findMaxElement(TreeNode root, int node1, int node2) {
        // Write your code here.
        if (search(root, node1) == null || search(root, node2) == null) {
            return -1;
        }

        int max = -1;

        TreeNode lca = findLCA(root, node1, node2);

        TreeNode temp = lca;

        while (temp.val != node1) {
            if (temp.val != node1) {
                max = Math.max(max, temp.val);
            }
            if (temp.val > node1) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        temp = lca;

        while (temp.val != node2) {
            if (temp.val != node2) {
                max = Math.max(max, temp.val);
            }
            if (temp.val > node2) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        return max;
    }

    public static TreeNode search(TreeNode root, int node) {
        if (root == null) {
            return root;
        }

        if (root.val == node) {
            return root;
        }

        if (root.val > node) {
            return search(root.left, node);
        } else {
            return search(root.right, node);
        }
    }

    public static TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) {
            return root;
        }

        if (root.val == p || root.val == q) {
            return root;
        }

        TreeNode lca1 = findLCA(root.left, p, q);
        TreeNode lca2 = findLCA(root.right, p, q);

        if (lca1 != null && lca2 != null) {
            return root;
        }

        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }
}
