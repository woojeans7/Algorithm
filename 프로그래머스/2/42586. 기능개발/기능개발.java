import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();

        // 1. 큐에 데이터 삽입
        for (int i = 0; i < progresses.length; i++) {
            progressQueue.offer(progresses[i]);
            speedQueue.offer(speeds[i]);
        }

        List<Integer> result = new ArrayList<>();

        while (!progressQueue.isEmpty()) {
            // 2. 하루치 진척도 누적
            int size = progressQueue.size();
            for (int i = 0; i < size; i++) {
                int currentProgress = progressQueue.poll();
                int currentSpeed = speedQueue.poll();
                progressQueue.offer(currentProgress + currentSpeed);
                speedQueue.offer(currentSpeed);
            }

            // 3. 배포 가능한 기능 체크
            int count = 0;
            while (!progressQueue.isEmpty() && progressQueue.peek() >= 100) {
                progressQueue.poll();
                speedQueue.poll();
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
