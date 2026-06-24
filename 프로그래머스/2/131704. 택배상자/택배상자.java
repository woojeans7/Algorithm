import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for(int box = 1; box <= order.length; box++){
            if(order[i] != box){
                stack.push(box);
                continue;
            }

            i++;
            answer++;

            while(!stack.isEmpty() && stack.peek() == order[i]){
                stack.pop();
                i++;
                answer++;
            }
        }
        return answer;
    }
}