class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        rec(candidates, list, new ArrayList<>(), target, 0);
        return list;
    }
    public void rec(int[] nums, List<List<Integer>> list,
                    List<Integer> res, int target, int idx) {
        if (target == 0) {
            list.add(new ArrayList<>(res));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            res.add(nums[i]);
            rec(nums, list, res, target - nums[i], i + 1);
            res.remove(res.size() - 1);
        }
    }
}