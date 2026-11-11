class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int len=nums.length;
        int[] res=new int[len-k+1];
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        int idx=0;
        res[idx]=nums[dq.peekFirst()];
        idx++;
        for(int i=k;i<len;i++){
            if(dq.peekFirst()==i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            res[idx++]=nums[dq.peekFirst()];
        }
        return res;
    }
}
