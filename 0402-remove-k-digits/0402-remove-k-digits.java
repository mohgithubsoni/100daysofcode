class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>stk=new Stack();
        StringBuilder sb=new StringBuilder();
        //incresing order stack maintain krna hai
        for(char i:num.toCharArray()){
            while(!stk.isEmpty() && k>0 && stk.peek()>i){
                stk.pop();
                k--;
            }
            stk.push(i);
        }
        while(!stk.isEmpty() && k>0){
            stk.pop();
            k--;
        }
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}