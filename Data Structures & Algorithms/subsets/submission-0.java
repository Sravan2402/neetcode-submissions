class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        n=(int)Math.pow(2,n);
        System.out.println(n);
        for(int i=0;i<n;i++){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<31;j++){
                if(check(i,j)){
                    l.add(nums[j]);
                }
            }
            list.add(new ArrayList(l));
        }
        return list;
    }
    public boolean check(int num,int i){
        return ((num & (1<<i))!=0);
    }
}
