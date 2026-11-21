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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> dq=new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size=dq.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode poll=dq.pollFirst();
                l.add(poll.val);
                if(poll.left!=null){
                    dq.addLast(poll.left);
                }
                if(poll.right!=null){
                    dq.addLast(poll.right);
                }
            }
            list.add(new ArrayList<>(l));
        }
        return list;
    }
}
