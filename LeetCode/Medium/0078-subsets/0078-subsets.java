class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(nums, answer, new ArrayList<>(), 0);
        return answer;
    }
    private void dfs(int[] nums, List<List<Integer>> answer, List<Integer> cur, int i){
        if(i == nums.length){
            answer.add(new ArrayList<>(cur));
            return;
        }
        else{
            cur.add(nums[i]);
            dfs(nums, answer, cur, i+1);
            cur.remove(cur.size()-1);
            dfs(nums, answer, cur, i+1);
        }

    }
}