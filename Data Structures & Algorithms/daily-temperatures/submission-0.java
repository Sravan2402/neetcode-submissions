class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        if(n==0){
            return res;
        }
        Deque<Integer> dq=new ArrayDeque<>();
        dq.push(n-1);
        res[n-1]=0;
        for(int i=n-2;i>=0;i--){
            while(!dq.isEmpty() && temperatures[dq.peekLast()]<=temperatures[i]){
                dq.pollLast();
            }
            res[i]=dq.isEmpty()?0:dq.peekLast()-i;
            dq.addLast(i);
        }
        return res;
    }
}
