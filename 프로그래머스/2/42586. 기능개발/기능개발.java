import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int remain = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.add(remain);
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            int cnt = 1;
            
            // 다음 작업이 현재보다 작거나 같으면 같이 배포
            while(!queue.isEmpty() && queue.peek() <= current){
                queue.poll();
                cnt++;    
            }
            
            answer.add(cnt);
        }
                
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}