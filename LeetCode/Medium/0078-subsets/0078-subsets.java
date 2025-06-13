class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        subset(nums, answer, list, 0);
        return answer;
        
    }
    public void subset(int[] nums, List<List<Integer>> answer, List<Integer> list, int depth){
        answer.add(new ArrayList<>(list));

        for(int i = depth; i < nums.length; i++){
            list.add(nums[i]);
            subset(nums,answer, list, i+1);
            list.remove(list.size() - 1);
        }
    }
}