class Solution {
    public boolean canPartition(int[] nums) {
        // 두 집합으로 나눴을 때, 각 집합의 합이 동일한지 찾는 문제
        int sum = 0;
        for(int num : nums) sum += num;

        // 홀수합이면 동일 분할 불가
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}