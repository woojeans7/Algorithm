import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int i = 0;
        while(i < d.length && d[i] <= budget){
            budget -= d[i];
            i++;
            answer++;
            if (budget==0){
                return answer;
            }
        }
            return answer;
        }
    }