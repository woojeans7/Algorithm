import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int lastCamera = -30001;
        int answer = 0;

        for(int[] route : routes){
            int in = route[0];
            int out = route[1];

            if(in > lastCamera){
                lastCamera = out;
                answer++;
            }
        }

        return answer;
    }
}