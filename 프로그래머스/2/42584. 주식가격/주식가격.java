import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty()){
                // 이전 가격이 현재 가격보다 크면 떨어진 것
                if(prices[stack.peek()] > prices[i]){
                    int prev = stack.pop();
                    answer[prev] = i - prev;
                }
                else break;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }
        return answer;
    }
}