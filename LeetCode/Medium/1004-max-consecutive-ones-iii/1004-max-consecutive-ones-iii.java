class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int left = 0, zero = 0, len = 0;

         for(int right = 0; right < n; right++){
            if(nums[right] == 0) zero++;

            while(zero > k){
                if(nums[left] == 0) zero--;
                left++;
            }

            len = Math.max(len, right-left+1);
        }

        return len;
    }
}