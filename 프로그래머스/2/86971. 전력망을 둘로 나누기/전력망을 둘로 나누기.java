import java.util.*;

public class Solution {
    int answer;
    int n;
    public int solution(int n, int[][] wires) {
        answer = n;
        this.n = n;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, visited, graph);

        return answer;
    }
    private int dfs(int cur, boolean[] visited, List<List<Integer>> graph){
        visited[cur] = true;
        int sum = 1;
        for(int next : graph.get(cur)){
            if(!visited[next]){
                int count = dfs(next, visited, graph);
                answer = Math.min(answer, Math.abs(n - count * 2));
                sum += count;
            }
        }
        return sum;
    }
}