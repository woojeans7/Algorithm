import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> candidates = new ArrayList<>();
        for(int i = 1; i <= n; i++) candidates.add(i);
        
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) factorial[i] = factorial[i - 1] * i;
        
        k -= 1;
        
        for(int i = 0; i  < n; i++){
            long unit = factorial[n - 1 - i];
            int idx = (int) (k / unit);
            k %= unit;
            answer[i] = candidates.remove(idx);
        }
        
        return answer;
    }
}