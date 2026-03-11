class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;

        int i = 0;
        while(i < n){
            if(nums[i] != 0){
                nums[idx++] = nums[i];
            }
            i++;
        }

        while(idx < n){
            nums[idx++] = 0;
        }
    }
}