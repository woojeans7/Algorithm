class Solution {
    public int solution(int[] numbers, int target) {
        return backtrack(numbers, target, 0, 0);
    }
    public int backtrack(int[] nums, int target, int cur, int idx){
        // 끝까지 도착하면 종료
        if(idx == nums.length){
            return (cur == target) ? 1: 0;
        }
        
        // 합계 구하기
        int sum  = 0;
        sum += backtrack(nums, target, cur+nums[idx], idx+1);
        sum += backtrack(nums, target, cur-nums[idx], idx+1);
        return sum;
    }
}