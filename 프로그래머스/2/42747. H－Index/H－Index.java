import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            int remain = n - i; // 이 인덱스부터 끝까지 남은 논문 수
            if (citations[i] >= remain) {
                return remain; // 조건을 만족하는 첫 지점이 최댓값
            }
        }
        return answer;
    }
}