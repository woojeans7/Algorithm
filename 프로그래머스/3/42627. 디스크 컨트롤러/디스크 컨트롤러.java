import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int idx = 0;
        int curTime = 0;
        int done = 0;
        int total = 0;

        while(done < n){
            while(idx < n && jobs[idx][0] <= curTime){
                pq.offer(jobs[idx++]);
            }

            if(pq.isEmpty()){
                curTime = jobs[idx][0];
                continue;
            }

            int[] job =  pq.poll();
            curTime += job[1];
            total += (curTime - job[0]);
            done++;
        }

        return total / n;
    }
}