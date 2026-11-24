
class Solution {
    public int goodNodes(TreeNode root) {
        return check(root, Integer.MIN_VALUE);
    }

    public int check(TreeNode curr, int max) {
        if (curr == null) {
            return 0;
        }
        int count = 0;

        if (curr.val >= max) {
            count++;
        }

        max = Math.max(max, curr.val);

        int left = check(curr.left, max);
        int right = check(curr.right, max);

        return count + left + right;
    }
}
