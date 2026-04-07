class Solution {
    public int numTilings(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        long[] dp = new long[n];
        dp[0] = 1; 
        dp[1] = 2;
        dp[2] = 5; 

        for(int i = 3; i < n; i++){
            dp[i] = (dp[i-3] + dp[i-1] * 2) % 1000000007;
        }

        return (int) dp[n-1];
    }
}