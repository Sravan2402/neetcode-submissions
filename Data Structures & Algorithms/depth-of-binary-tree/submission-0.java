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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=0;
        Deque<TreeNode> dq=new ArrayDeque<>();
        dq.addLast(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){
                TreeNode poll=dq.pollFirst();
                if(poll.left!=null){
                    dq.addLast(poll.left);
                }
                if(poll.right!=null){
                    dq.addLast(poll.right);
                }
            }
            count++;
        }
        return count;
    }
}
