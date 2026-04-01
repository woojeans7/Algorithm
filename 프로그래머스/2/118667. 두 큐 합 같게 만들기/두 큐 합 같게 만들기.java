import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum = 0;
        long qSum1 = 0;
        long qSum2 = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            qSum1 += queue1[i];
            qSum2 += queue2[i];
            sum += qSum1 + qSum2;
            
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        int count = 0;
        long target = sum / 2;
        int answer = 0;
        while(qSum1 != qSum2 && count < n*3){
            if(qSum1 > qSum2){
                int cur = q1.poll();
                q2.offer(cur);
                qSum1 -= cur;
                qSum2 += cur;
                answer++;
            }
            else{
                int cur = q2.poll();
                q1.offer(cur);
                qSum1 += cur;
                qSum2 -= cur;
                answer++;
            }
            count++;
        }
        
        if(count >= n*3) return -1;
        
        return answer;
    }
}