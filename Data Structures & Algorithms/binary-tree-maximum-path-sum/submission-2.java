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
    private int max=Integer.MIN_VALUE;
    private int getMaxPathSum(TreeNode root){
        if(root==null)
        return 0;
        int left=Math.max(0,getMaxPathSum(root.left));
        int right=Math.max(0,getMaxPathSum(root.right));
        int currentPath=root.val+left+right;
        max=Math.max(max,currentPath);
        return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        if(root==null)
        return 0;
        getMaxPathSum(root);
        return max;

    }
}
