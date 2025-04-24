import java.util.*;

class Solution {
    public int[] solution(long n) {
        String num = Long.toString(n);
        int ln = num.length();
        int[] answer = new int[ln];
        for (int i=0; i < ln; i++){
            int  j = ln-1 -i;
            answer[i] = num.charAt(j) -'0';
        }
        return answer;
    }
}