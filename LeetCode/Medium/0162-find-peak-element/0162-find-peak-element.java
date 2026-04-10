class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left < right){
            int mid = (left + right) / 2;
            int prev = prev(mid, nums);
            int next = next(mid, nums);

            if(prev < nums[mid] && nums[mid] > next){
                return mid;
            }
            else if(prev > nums[mid]){
                right = mid;
            }
            else if(next > nums[mid]){
                left = mid + 1;
            }
        }
        return left;
    }
    private int prev(int mid, int[] nums){
        if(mid == 0) return Integer.MIN_VALUE;
        return nums[mid-1];
    }
    private int next(int mid, int[] nums){
        if(mid == nums.length-1) return Integer.MIN_VALUE;
        return nums[mid+1];
    }
}