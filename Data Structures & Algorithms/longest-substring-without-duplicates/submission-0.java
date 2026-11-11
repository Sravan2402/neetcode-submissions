class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int n=s.length();
        int p1=0;
        Set<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(s.charAt(i))){
                while(p1<i && set.contains(s.charAt(i))){
                    set.remove(s.charAt(p1));
                    p1++;
                }
            }
            set.add(s.charAt(i));
            maxLen=Math.max(maxLen,set.size());
        }
        return maxLen;
    }
}
