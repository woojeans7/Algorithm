import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;

        // 모든 음식의 스코빌 지수가 K이상이 될때까지 반복
        // 즉, 첫 번째 지수가 K보다 클 때까지
        while(!pq.isEmpty() && pq.size() > 1 && pq.peek() < K) {
            // 2개를 무조건 뽑고 새로운 스코빌 지수 계산
            int first = pq.poll();
            int second = pq.poll();
            int newNum = newScoville(first, second);

             //큐에 넣기
            pq.offer(newNum);
            answer++;

        }
        
        if(pq.peek() < K) return -1;
        
        return answer;
    }
    private int newScoville(int first, int second) {
        return first + second * 2;
    }
}