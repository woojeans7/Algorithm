import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 1. 모든 예약을 (체크인시간, 체크아웃시간) 쌍으로 숫자 변환
        List<int[]> booking = new ArrayList<>();
        
        for(String[] time : book_time){
            String checkIn = time[0];
            String checkOut = time[1];
            
            booking.add(new int[]{toMinutes(checkIn), toMinutes(checkOut)});
        }
        // 2. 체크인 시간 기준으로 오름차순 정렬
        Collections.sort(booking, (a, b) -> {
            return a[0] - b[0];
        });
        // 3. 최소 힙(minHeap) 준비 — "현재 사용 중인 방들의 체크아웃 시간"을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 4. for 각 예약 (checkIn, checkOut) in 정렬된 예약들:
        for(int[] time : booking){
            int checkIn = time[0];
            int checkOut = time[1];
            
            // if 힙이 비어있지 않고, 힙의 최솟값(가장 빨리 끝나는 방의 체크아웃시간) <= checkIn:
            if(!pq.isEmpty() && pq.peek() + 10 <= checkIn){
                // 그 방이 이미 비었으니 재사용 가능 -힙에서 최솟값 pop
                pq.poll();
            }
            // 재사용했든 안 했든, 이 예약은 방을 하나 쓰는 중이므로 push - 힙에 checkOut push
            pq.offer(checkOut);
            
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    private int toMinutes(String time){
        String[] tmp = time.split(":");
        int h = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        
        return h * 60 + m;
    }
}