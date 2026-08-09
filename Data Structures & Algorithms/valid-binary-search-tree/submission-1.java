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
   private static void inorder(TreeNode node, List<Integer>result){
    if(node==null)
    return;
    inorder(node.left,result);
    result.add(node.val);
    inorder(node.right,result);
   }
    public boolean isValidBST(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        inorder(root,result);
        for(int i=0;i<result.size()-1;i++){
          if(result.get(i)>=result.get(i+1))
          return false;
        }
        return true;
    }
}
