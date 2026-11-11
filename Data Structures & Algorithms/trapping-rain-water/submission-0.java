class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        leftToRight[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftToRight[i] = Math.max(leftToRight[i - 1], height[i]);
        }
        rightToLeft[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightToLeft[i] = Math.max(rightToLeft[i + 1], height[i]);
        }
        int water = 0;

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftToRight[i], rightToLeft[i]);
            water += waterLevel - height[i];
        }

        return water;
    }
}