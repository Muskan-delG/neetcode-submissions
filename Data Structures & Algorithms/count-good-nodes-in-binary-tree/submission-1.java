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
    private static int countGoodNodes(TreeNode root, int maxSoFar){
        if(root==null)
        return 0;
        int current= root.val>=maxSoFar ? 1:0;
        maxSoFar=Math.max(root.val,maxSoFar);
        return current+countGoodNodes(root.left,maxSoFar) + countGoodNodes(root.right,maxSoFar);
    }
    public int goodNodes(TreeNode root) {
        if(root==null)
        return 0;
      return  countGoodNodes(root,root.val);
    }
}
