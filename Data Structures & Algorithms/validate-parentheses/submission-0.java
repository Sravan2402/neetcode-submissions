class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='}' || ch==']' || ch==')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()==ch){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                if(ch=='{'){
                    stack.push('}');
                }
                else if(ch=='['){
                    stack.push(']');
                }
                else if(ch=='('){
                    stack.push(')');
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}
