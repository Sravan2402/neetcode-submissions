class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> pairs =
                twoSum(nums, i + 1, -nums[i]);

            for (List<Integer> pair : pairs) {
                List<Integer> triplet = new ArrayList<>();

                triplet.add(nums[i]);
                triplet.add(pair.get(0));
                triplet.add(pair.get(1));

                result.add(triplet);
            }
        }

        return result;
    }

    public static List<List<Integer>> twoSum(
            int[] nums, int start, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int p1 = start;
        int p2 = nums.length - 1;

        while (p1 < p2) {

            int sum = nums[p1] + nums[p2];

            if (sum == target) {

                result.add(Arrays.asList(
                    nums[p1],
                    nums[p2]
                ));

                int leftValue = nums[p1];
                int rightValue = nums[p2];

                // Skip duplicates
                while (p1 < p2 && nums[p1] == leftValue) {
                    p1++;
                }

                while (p1 < p2 && nums[p2] == rightValue) {
                    p2--;
                }

            } 
            else if (sum < target) {
                p1++;
            } 
            else {
                p2--;
            }
        }

        return result;
    }
}