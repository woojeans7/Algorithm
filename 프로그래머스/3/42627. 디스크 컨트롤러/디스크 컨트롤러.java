import java.util.*;

class Solution {
    // 객체를 생성
    class Work implements Comparable<Work>{
        int no; 
        int request;
        int time;
        
        public Work(int no, int request, int time){
            this.no = no;
            this.request = request;
            this.time = time;
        }
        
        @Override
        public int compareTo(Work w){
            if(this.time == w.time){
                if(this.request == w.request){
                    return this.no - w.no;
                }
                return this.request - w.request;
            }
            return this.time - w.time;
        }
    }
    public int solution(int[][] jobs) {
        
        int count = 0;
        int[] turnaround = new int[jobs.length];
        
        Queue<Work> pq =  new PriorityQueue<>();
        
        int curTime = 0; // 현재시간
        int idx = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청시간 정렬
        
        // 작업만큼 반복
        while(count < jobs.length){
            // 시간 안에 요청시간이 존재하면 큐에 저장
            while(idx < jobs.length && jobs[idx][0] <= curTime){
                pq.offer(new Work(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
        
            // 큐가 비어있을 때 
            if (pq.isEmpty()) {
                curTime = jobs[idx][0]; // 아직 도착 안한 작업 있을 경우 시간 점프
                continue;
            }

            // 큐에서 가장 짧은 작업 시간 꺼내 처리
            Work cur = pq.poll();
            curTime += cur.time; // 현재 시간에 소요시간 더함
            turnaround[cur.no] = curTime - cur.request; // 완료시간 - 요청시간
            count++;
        }
        
        int sum = 0;
        // 요청 시간과 종료 시간을 빼서 반환 후 평균 구하기
        for(int i = 0; i < jobs.length; i++){
            sum += turnaround[i];
        }
        
        return sum / jobs.length;
    }
}