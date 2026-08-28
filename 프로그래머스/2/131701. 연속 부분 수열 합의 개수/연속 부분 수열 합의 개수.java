import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        
        // 원형 수열을 처리하기 위해 배열을 2배로 확장
        int[] extended = new int[n * 2];
        for (int i = 0; i < n; i++) {
            extended[i] = elements[i];
            extended[i + n] = elements[i];
        }
        
        // 길이(1부터 n까지)별로 연속 부분 수열의 합 구하기
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < i + len; j++) {
                    sum += extended[j];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
