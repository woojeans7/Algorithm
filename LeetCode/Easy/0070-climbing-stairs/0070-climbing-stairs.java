class Solution {
    public int climbStairs(int n) {
        // 초기화
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1,1);
        dp.put(2,2);

        // 점화식
        for(int i = 3; i <= n; i++){
            dp.put(i, dp.get(i-1) + dp.get(i-2));
        }

        return dp.get(n);
    }
}