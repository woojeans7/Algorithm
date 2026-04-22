class Solution {
    public int splitArray(int[] nums, int k) {
        int answer = 0;

        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while(left <= right){
            int mid = (left + right) / 2;

            if(count(nums, mid) <= k){
                answer = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return answer;
    }
    private int count(int[] nums, int capacity){
        int cnt = 1, sum = 0;
        for(int num : nums){
            if(sum + num > capacity){
                cnt++;
                sum = num;
            }
            else sum += num;
        }
        return cnt;
    }
}