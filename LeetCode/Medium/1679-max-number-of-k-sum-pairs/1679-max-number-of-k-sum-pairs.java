class Solution {
    public int maxOperations(int[] nums, int k) {
        // nums 배열과 정수 k가 주어짐
        // 두 합이 k가 되는 개수를 반환하는 문제
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        Arrays.sort(nums);

        while(left < right){
            if(nums[left] + nums[right] == k){
                count++;
                left++;
                right--;
            }
            else{
                if(nums[left] + nums[right] > k) right--;
                else left++;         
            }
        }
        return count;
    }
}