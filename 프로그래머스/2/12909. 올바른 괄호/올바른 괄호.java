import java.util.*;

class Solution {
    boolean solution(String s) {
        // 스택 초기화
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            // 열린 괄호면 스택에 저장
            if(c == '('){
                stack.push(c);
            }
            // 닫힌 괄호일 때
            else{
                // 1. 시작부터 닫힌 괄호일 경우
                if(stack.isEmpty()) return false;
                
                // 2. 열린 괄호가 있을 경우
                char top = stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}