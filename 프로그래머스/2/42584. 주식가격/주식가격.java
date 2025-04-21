import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int price : prices) {
            queue.offer(price);
        }
        
        for (int i = 0; i < prices.length; i++){
            int current = queue.poll();
            int cnt = 0;
            
            for(int num : queue){
                cnt++;
                if (current > num) break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}