import java.util.*;

class Solution {
    boolean isValid(String s){
        // if 올바른 괄호면 return true
        Deque<Character> stack = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            // if(열린 괄호면) stack에서 push
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                
                // 짝이 안맞으면
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
        
    }
    public int solution(String s) {
        int answer = 0;
        String doubleS = s + s;
        System.out.println(doubleS);
        
        // 회전 시킬 때마다 isValid() 호출하고 true이면 answer++;
        for(int i = 0; i < s.length(); i++){
            String rotated = doubleS.substring(i,i+s.length());
            if(isValid(rotated)) answer += 1;
        }
        
        
        
        return answer;
    }
}