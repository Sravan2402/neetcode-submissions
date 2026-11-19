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
    static int maxLen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxLen=0;
        rec(root);
        return maxLen;
    }
    public int rec(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=rec(root.left);
        int right=rec(root.right);
        maxLen=Math.max(maxLen,left+right);
        return 1+Math.max(left,right);
    }
}
