class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> memo = new HashMap<>();

        return dp(n-1, memo, nums);

    }
    public int dp(int n, Map<Integer, Integer> memo, int[] nums){
        memo.put(0, nums[0]);
        if(n == 1) return nums[n];
        if(n >= 2){
            memo.put(1, Math.max(nums[0], nums[1]));

            if(!memo.containsKey(n)){
                memo.put(n, Math.max(dp(n-1, memo, nums), dp(n-2, memo, nums) + nums[n]));
            }
        }

        return memo.get(n);

    }
}