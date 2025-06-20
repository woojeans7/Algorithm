class Solution {
    public int climbStairs(int n) {
        int res = dp(n);

        return res;

    }
    public int dp(int n){
        Map<Integer, Integer> memo = new HashMap<>();

        memo.put(1,1);
        memo.put(2,2);

        for(int i = 3; i <= n; i++){
            memo.put(i, memo.get(i-1) + memo.get(i-2));
        }

        return memo.get(n);
    }
}