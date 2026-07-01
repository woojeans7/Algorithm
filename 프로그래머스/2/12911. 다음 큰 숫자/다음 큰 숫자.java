import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int answer = n + 1;
        while(true){
            if(calcOne(n) == calcOne(answer)) return answer;

            answer++;
        }

    }
    private int calcOne(int n){
        int count = 0;
        while (n > 0) {
            count += n & 1; // 마지막 비트가 1인지 체크
            n >>= 1;        // 오른쪽으로 1칸 shift
        }
        return count;
    }
}