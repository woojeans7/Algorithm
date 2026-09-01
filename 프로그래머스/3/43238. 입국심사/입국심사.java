import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long low = 0;
        long high = times[times.length - 1] * (long) n;

        while(low <= high){
            long mid = (low + high) / 2;
            long complete = 0;

            // 몫을 누적
            for(int time : times){
                complete += mid / time;
            }

            // n명 이상 검사할 수 있으면 더 짧은 시간 안에 할 수 있는지 탐색
            if(complete >= n) {
                high = mid - 1;
                answer = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return answer;
    }
}