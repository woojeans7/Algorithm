import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
		    //✅ d를 정렬한다.
        Arrays.sort(d);
        int result = 0;
        
        //✅ 예산이 적은 부서부터 전체 예산이 소진될 때까지 지급한다.
        for (int price : d) {
            budget -= price;
            if (budget < 0) break;
            result++;
        }
        
        //✅ 예산을 지급한 부서의 개수를 반환한다.
        return result;
    }
}