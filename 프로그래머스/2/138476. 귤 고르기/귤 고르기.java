import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Integer> count = new ArrayList<>(map.values());
        count.sort(Collections.reverseOrder());
        
        int types = 0;
        int countSum = 0;
        for(int cnt : count){
            countSum += cnt;
            types++;
            
            if(countSum >= k) break;
        }
        
        return types;
    }
}