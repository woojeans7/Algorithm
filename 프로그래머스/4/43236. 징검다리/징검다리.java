    import java.util.*;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int[] positions = new int[rocks.length + 2];
        positions[0] = 0;
        positions[rocks.length + 1] = distance;

        for(int i = 1; i <= rocks.length; i++){
            positions[i] = rocks[i - 1];
        }
        int low = 0;
        int high = distance;
        while(low <= high){
            int mid = (low + high) / 2;

            if(canRemove(positions, n, mid)){
                answer = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return answer;
    }
    // 바위를 제거하는 로직 (결정 알고리즘)
    private boolean canRemove(int[] positions, int n, int dist){
        int cnt = 0;
        int last = positions[0];

        for(int i = 1; i < positions.length; i++){
            if(positions[i] - last < dist){
                cnt++;
                if(cnt > n) return false;
            }
            else last = positions[i];
        }

        return cnt <= n;
    }
}
