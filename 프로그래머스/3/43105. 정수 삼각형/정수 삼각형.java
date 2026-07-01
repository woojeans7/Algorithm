import java.util.*;

class Solution {
    public int solution(int[][] triangle) {

        int h = triangle.length;

        // dp[i][j] = i행 j열까지 왔을 때 최대 합
        int[][] dp = new int[h][];
        for (int i = 0; i < h; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < h; i++){
            int w =  triangle[i].length;
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][w-1] = triangle[i][w-1] + dp[i-1][w-2];
            for(int j = 1; j < w - 1; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int answer = 0;
        for (int val : dp[h-1]) {
            answer = Math.max(answer, val);
        }

        return answer;
    }
}
