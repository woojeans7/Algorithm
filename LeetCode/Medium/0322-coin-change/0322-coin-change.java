class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // 1. 초기화
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // base 조건

        // 2. 점화식 
        for(int i =1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        // 3. 결과 반환
        return dp[amount] < amount+1 ? dp[amount] : -1;
    }
}