import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        char prev = s.charAt(0);
        stack.push(prev);
        for(int i = 1; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
            }
            else stack.push(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }
}