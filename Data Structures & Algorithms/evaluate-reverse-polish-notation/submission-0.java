class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>(Set.of("+", "-", "*", "/"));
        Deque<Integer> st=new ArrayDeque<>();
        for(String str:tokens){
            if(set.contains(str)){
                int num1=st.pop();
                int num2=st.pop();
                if(str.equals("+")){
                    int total=num1+num2;
                    st.push(total);
                }
                else if(str.equals("-")){
                    int sub=num2-num1;
                    st.push(sub);
                }
                else if(str.equals("*")){
                    int mul=num1*num2;
                    st.push(mul);
                }
                else{
                    if(num1!=0){
                        st.push(Math.round(num2/num1));
                    }
                    else{
                        return -1;
                    }
                }
            }
            else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.size()>1?-1:st.peek();
    }
}
