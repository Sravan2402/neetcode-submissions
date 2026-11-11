
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min = 1;
        int max = 0;

        for (int i : piles) {
            max = Math.max(max, i);
        }

        int res = max;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            long currSum = 0;

            for (int i : piles) {
                currSum += (i + mid - 1) / mid;
            }

            if (currSum <= h) {
                res = mid;
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }

        return res;
    }
}
