import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int idx = 0;
        
        while (idx < truck_weights.length) {
            time++;
            // 다리 앞에서 트럭 하나 빠짐
            currentWeight -= queue.poll();

            // 다음 트럭이 올라갈 수 있는지 확인
            if (currentWeight + truck_weights[idx] <= weight) {
                queue.offer(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                // 못 올라가면 빈 자리(0) 넣기
                queue.offer(0);
            }
        }
        
        // 마지막 트럭이 다리를 완전히 건너는 시간
        return time + bridge_length;
    }
}