package trees;

public class HouseRobber {
    public static void main(String[] args) {
    }

    public int rob(TreeNode root) {
        HouseRobberPair result = helper(root);

        return Math.max(result.withRobbery, result.withoutRobbery);
    }

    public HouseRobberPair helper(TreeNode root) {
        if (root == null) {
            return new HouseRobberPair();
        }

        HouseRobberPair left = helper(root.left);
        HouseRobberPair right = helper(root.right);

        int ansWithRobbery = root.val + left.withoutRobbery + right.withoutRobbery;

        int ansWithoutRobbery = Math.max(left.withRobbery, left.withoutRobbery)
                + Math.max(right.withRobbery, right.withoutRobbery);
        HouseRobberPair house = new HouseRobberPair();
        house.withRobbery = ansWithRobbery;
        house.withoutRobbery = ansWithoutRobbery;
        return house;
    }

    class HouseRobberPair {
        int withRobbery = 0;
        int withoutRobbery = 0;
    }
}
