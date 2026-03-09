import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            else{
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}