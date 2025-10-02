import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {

        // 1. 정렬
        Arrays.sort(d);
        
        // System.out.println(Arrays.toString(d)); // 디버깅용
        
        // 2. 예산에서 부서별 금액 차감
        int cnt = 0;
        for(int i : d){
            if(budget >= i){
                budget -= i;
                // 3. 지급한 부서 카운팅
                cnt += 1;
            }
        }
        return cnt;
    }
}