class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp 초기화
        int[][] dp = new int[text1.length() + 1][text2.length()+1];

        // 순회
        for(int i = 1; i < text1.length() + 1; i++){
            char c1 = text1.charAt(i-1);
            for(int j = 1; j < text2.length()+1; j++){
                char c2 = text2.charAt(j-1);
                // text1의 i-1번째 글자와 text2의 j-1번째 글자가 같으면 dp에 저장
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}