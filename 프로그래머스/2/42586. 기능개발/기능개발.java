import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        List<Integer> result = new ArrayList<>();
            
        // 큐에 남은 작업일을 저장
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int rest = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.offer(rest);
        }
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            int count = 1;
            
            // 다음 작업이 현재보다 작거나 같으면 같이 배포
            while(!queue.isEmpty() && queue.peek() <= current){
                queue.poll();
                count++;    
            }
            
            result.add(count);
        }
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}