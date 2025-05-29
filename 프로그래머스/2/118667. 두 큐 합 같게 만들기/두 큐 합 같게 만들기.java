import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            
            q1Sum += queue1[i]; 
            q2Sum += queue2[i];
        }

        while(q1Sum != q2Sum){
            if(q1Sum > q2Sum){
                int cur = q1.poll(); 
                q2Sum += cur;
                q1Sum -= cur;
                q2.offer(cur);
                count++;
            }
            else if(q1Sum < q2Sum){
                int cur = q2.poll(); 
                q1Sum += cur;
                q2Sum -= cur;
                q1.offer(cur);
                count++;
            }
            
            if(count > queue1.length * 3) return -1;
        }
        
        return count;
    }
}