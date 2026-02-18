class Solution {
    public int sumNumbers(TreeNode root) {
        return sumPath(root, 0);
    }

    static int sumPath(TreeNode root, int val){
        if(root == null) return 0;

        val = val * 10 + root.val;

        // leaf node
        if (root.left == null && root.right == null){
            return val;
        }

        // retrun sum of both the right as well as left side of  the tree
        return sumPath(root.left, val) + sumPath(root.right, val);
    }
}
