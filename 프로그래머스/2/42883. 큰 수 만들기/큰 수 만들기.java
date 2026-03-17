import java.util.*;

class Solution {
    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        int removed = 0;

        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);

            // 스택 top보다 현재 숫자가 크면 → top 제거
            while (!stack.isEmpty() && removed < k
                    && stack.peek() < cur) {
                stack.pop();
                removed++;
            }

            stack.push(cur);
        }

        // 아직 덜 제거했으면 뒤에서 제거
        while (removed < k) {
            stack.pop();
            removed++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}