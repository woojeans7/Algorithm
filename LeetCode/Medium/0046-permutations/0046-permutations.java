import java.util.*;

class Solution {
    static boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();

        permutation(answer, nums,perm, n, 0);
        return answer;
    }

    public void permutation(List<List<Integer>> answer, int[] nums, List<Integer> perm, int n, int depth){
        
        if (depth == n) {
            answer.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm.add(nums[i]);
                permutation(answer, nums, perm, n, depth + 1);
                visited[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}