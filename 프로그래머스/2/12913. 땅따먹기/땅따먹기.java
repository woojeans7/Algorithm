class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        dp[0] = land[0];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 4; j++){
                int max = 0;
                for(int k = 0; k < 4; k++){
                    if(k == j) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + max;
            }
        }
        int answer = 0;
        for(int k : dp[n-1]){
            answer = Math.max(answer, k);
        }
        
        return answer;
    }
}