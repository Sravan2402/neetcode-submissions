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
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> dq=new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            for(int i=0;i<size;i++){
                TreeNode poll=dq.pollFirst();
                if(i==size-1){
                    list.add(poll.val);
                }
                if(poll.left!=null){
                    dq.add(poll.left);
                }
                if(poll.right!=null){
                    dq.add(poll.right);
                }
            }
        }
        return list;
    }
}
