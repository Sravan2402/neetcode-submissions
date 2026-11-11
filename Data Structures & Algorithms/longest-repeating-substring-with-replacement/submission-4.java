class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int n=s.length();
        int maxlen=0;
        int maxfreq=0;
        int p1=0;
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'A';
            count[idx]++;
            maxlen=Math.max(maxlen,count[idx]);
            if((i-p1)-maxlen>=k){
                int currmax=0;
                while((i-p1)-maxlen>=k){
                    int leftidx=s.charAt(p1)-'A';
                    count[leftidx]--;
                    for(int j=0;j<26;j++){
                        currmax=Math.max(currmax,count[j]);
                    }
                    p1++;
                    maxlen=currmax;
                    // System.out.println("maxlen"+maxlen);
                }
                maxlen=currmax;
            }
            else{
                maxfreq=Math.max(maxfreq,i-p1+1);
            }
        }
        return maxfreq;
    }
}
