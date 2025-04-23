import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> s = new LinkedList<>();

        // 1. 큐에 데이터 삽입
        for (int i = 0; i < progresses.length; i++) {
            q.offer(progresses[i]);
            s.offer(speeds[i]);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            // 2. 하루치 진척도 누적
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currentProgress = q.poll();
                int currentSpeed = s.poll();
                q.offer(currentProgress + currentSpeed);
                s.offer(currentSpeed);
            }

            // 3. 배포 가능한 기능 체크
            int count = 0;
            while (!q.isEmpty() && q.peek() >= 100) {
                q.poll();
                s.poll();
                count++;
            }

            // 4. 배포가 있었다면 결과에 추가
            if (count > 0) {
                result.add(count);
            }
        }

        // 5. 결과 리스트를 배열로 변환 후 리턴
        return result.stream().mapToInt(i -> i).toArray();
    }
}
