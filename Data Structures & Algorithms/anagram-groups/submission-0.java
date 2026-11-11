class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        for(String st:strs){
            char[] sort=(st.toCharArray());
            Arrays.sort(sort);
            String str=new String(sort);
            if(mp.containsKey(str)){
                mp.get(str).add(st);
            }
            else{
                List<String> li=new ArrayList<>();
                li.add(st);
            mp.put(str,li);
            }
        }
        List<List<String>> list=new ArrayList<>();
        for(List<String> lis:mp.values()){
            list.add(new ArrayList<>(lis));
        }
        return list;
    }
}
