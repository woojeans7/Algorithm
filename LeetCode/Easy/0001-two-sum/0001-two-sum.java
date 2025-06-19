class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for(int i= 0; i < nums.length; i++){
            int needed = target - nums[i];
            if(memo.containsKey(needed)){
                return new int[] {memo.get(needed), i};
            }
            memo.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}