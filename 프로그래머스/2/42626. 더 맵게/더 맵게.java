import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;

        // 가장 작은 값이 K 미만이고, 섞을 수 있는 음식(2개 이상)이 남아있을 때 반복
        while (pq.peek() < K && pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first + second * 2);
            answer++;
        }

        // 루프 종료 후 가장 작은 값이 K 이상인지 확인
        return pq.peek() >= K ? answer : -1;
    }
}