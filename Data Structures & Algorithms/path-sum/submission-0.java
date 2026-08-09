/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static boolean dfs(TreeNode root, int sum, int targetSum){
        if(root==null)
        return false;
        if(root.left== null && root.right==null){
            if(sum + root.val == targetSum)
            return true;
            return false;
        }
        boolean left=dfs(root.left,sum+root.val,targetSum);
        boolean right=dfs(root.right,sum+root.val,targetSum);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, 0, targetSum);
    }
}