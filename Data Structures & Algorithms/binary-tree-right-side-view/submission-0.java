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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
        return result;
        // List<List<Integer>>temp=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>t=new ArrayList<>();
            for(int i=1;i<=size;i++){
                TreeNode node=q.poll();
                t.add(node.val);
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);

            }
            result.add(t.get(t.size()-1));
        }
        return result;
    }
}
