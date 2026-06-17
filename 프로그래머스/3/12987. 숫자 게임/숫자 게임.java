import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        // "B는 A[i]를 이길 수 있는 카드 중 가장 작은 카드를 써야 한다."
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && B[j] <= A[i]) j++;
            if(j < n){
                answer++;
                j++;
            }
        }
        return answer;
    }
}