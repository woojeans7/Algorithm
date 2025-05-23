class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // 불가능한 값으로 만들기 위해 최대 양에 1을 더해줌.

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; // 0원을 만들기 위한 동전 수는 0

        for(int i=0; i < dp.length; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }
        return (dp[amount] != max) ? dp[amount] : -1;
    }
}