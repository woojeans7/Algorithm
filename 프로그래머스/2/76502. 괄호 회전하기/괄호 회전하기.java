import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s + s;
        
        for(int i = 0; i < s.length(); i++){
            String rotated = str.substring(i, i+s.length());
            if(isValid(rotated)) answer++;
        }
            
        return answer;
    }
    public boolean isValid(String s){
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c:s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}