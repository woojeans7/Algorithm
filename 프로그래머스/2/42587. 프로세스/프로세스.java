import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
    
        int n = priorities.length;
    
        Queue<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            queue.offer(new int[]{i, priorities[i]});
        }
    
        priorities = Arrays.stream(priorities)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        int idx = 0;
        int count = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[1] == priorities[idx]){
                count++;
                if(cur[0] == location) return count;
                idx++;
            }
            else{
                queue.offer(cur);
            }
        }
        
        return count;
    }
}