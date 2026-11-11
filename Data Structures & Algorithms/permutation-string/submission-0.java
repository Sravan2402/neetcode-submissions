class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] flag=new int[26];
        for(char ch:s1.toCharArray()){
            flag[ch-'a']++;
        }
        int[] win=new int[26];
        for(int i=0;i<s1.length();i++){
            win[s2.charAt(i)-'a']++;
        }
        boolean fla=true;
        for(int i=0;i<26;i++){
            if(flag[i]!=win[i]){
                fla=false;
            }
        }
        if(fla){
            return fla;
        }
        for(int i=s1.length();i<s2.length();i++){
            int idx=s2.charAt(i-s1.length())-'a';
            win[idx]--;
            int curridx=s2.charAt(i)-'a';
            win[curridx]++;
            boolean fl=true;
            for(int j=0;j<26;j++){
                if(flag[j]!=win[j]){
                    fl=false;
                    break;
                }
            }
            if(fl){
                return true;
            }
        }
        return false;
    }
}
