class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,target, 0, 0);
    }
    private int dfs(int[] numbers, int target, int depth, int cur){
        if(depth == numbers.length){
            return cur == target ? 1 : 0;
        }
        
        int sum = 0;
        sum += dfs(numbers, target, depth + 1, cur + numbers[depth]);
        sum += dfs(numbers, target, depth + 1, cur - numbers[depth]);
        
        return sum;
    }
}