import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (isValid(s, i, len)) answer++;
        }

        return answer;
    }

    private boolean isValid(String s, int start, int len) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            // 나머지 연산으로 문자열을 잘라내지 않고 회전 효과를 냄
            char c = s.charAt((start + i) % len);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}