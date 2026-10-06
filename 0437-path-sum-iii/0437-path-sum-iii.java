class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        // Check paths starting from the current node, then recurse for children
        return helper(root, 0L, targetSum) 
             + pathSum(root.left, targetSum) 
             + pathSum(root.right, targetSum);
    }

    // Change 'current' and 'target' to long to prevent integer overflow
    private int helper(TreeNode root, long current, long target) {
        if (root == null) return 0;
        
        current += root.val;
        
        int count = (current == target) ? 1 : 0;
        
        count += helper(root.left, current, target);
        count += helper(root.right, current, target);
        
        return count;
    }
}