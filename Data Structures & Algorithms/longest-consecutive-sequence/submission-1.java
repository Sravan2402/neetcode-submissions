class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0;
        for(int i:nums){
            if(!set.contains(i-1)){
                int curr=i;
                int cnt=0;
                while(set.contains(curr)){
                    cnt++;
                    curr++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}
