class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), answer, 0);

        return answer;
    }
    private void backtrack(int start, int n, int k, List<Integer> cur, List<List<Integer>> ans, int sum){
        if(cur.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for(int i = start; i <= 9; i++){
            cur.add(i);
            sum += i;
            backtrack(i+1, n, k, cur, ans, sum);
            cur.remove(cur.size() - 1);
            sum -= i;
        }
    }
}