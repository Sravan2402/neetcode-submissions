class Node{
    String value;
    int time;
    Node(String value,int time){
        this.value=value;
        this.time=time;
    }
}
class TimeMap {
    Map<String,List<Node>> mp=new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(mp.containsKey(key)){
            mp.get(key).add(new Node(value,timestamp));
        }
        else{
            List<Node> list=new ArrayList<>();
            list.add(new Node(value,timestamp));
            mp.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        String value="";
        int ti=Integer.MIN_VALUE;
        if(mp.containsKey(key)){
            for(Node e:mp.get(key)){
                int currtime=e.time;
                if(currtime>ti && currtime<=timestamp){
                    ti=currtime;
                    value=e.value;
                }
            }
        }
        return value;
    }
}
