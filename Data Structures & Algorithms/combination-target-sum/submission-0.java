class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        rec(0,new ArrayList<>(),target,nums,list,0);
        return list;
    }
    public void rec(int currSum,List<Integer> list,int target,int[] nums,List<List<Integer>> res,int idx){
        if(currSum>target){
            return;
        }
        if(currSum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            currSum+=nums[i];
            list.add(nums[i]);
            rec(currSum,list,target,nums,res,i);
            currSum-=nums[i];
            list.remove(list.size()-1);
        }
    }
}
