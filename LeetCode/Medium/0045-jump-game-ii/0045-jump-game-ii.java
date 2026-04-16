class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1;

        int jumps = 0;
        int cur = 0;
        int max = 0;

        for(int i=0; i < n; i++){
            max = Math.max(max, i + nums[i]);

            if(i == cur){
                jumps++;
                cur = max;
            }
        }

        return jumps;
    }
}