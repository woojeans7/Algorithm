import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        int low = 1;
        int high = 100000;

        while(low <= high){
            int mid = (low + high)/2;

            // 숙련도 mid가 주어졌을 때 깰 수 있는지
            if(isClear(diffs, times, mid, limit)){
                answer = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return answer;
    }
    private boolean isClear(int[] diffs, int[] times, int level, long limit){
        // 소요시간
        long turnAround = 0;
        // 현재 퍼즐 비교
        for(int i = 0; i < diffs.length; i++){
            int diff = diffs[i];
            int curTime = times[i];

            // diff <= level이면 안틀림 - 현재 시간 소요
            if(diff <= level){
                turnAround += curTime;
            }
            // 숙련도가 낮으면 diff - level번만큼 틀리고 틀릴 때 마다 현재시간+이전시간만큼 감소
            else{
                int k = diff - level;
                int failTime = curTime + times[i-1];
                turnAround += k * failTime + curTime;
            }
            if (turnAround > limit) return false;
        }
        return limit - turnAround >= 0;
    }
}


