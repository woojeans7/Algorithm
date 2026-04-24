class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        cur.add(0);
        dfs(cur, n, graph, 0, answer);
        
        return answer;
    }
    private void dfs(List<Integer> cur, int n, int[][] graph, int node, List<List<Integer>> answer){
        if(node == n-1){
            answer.add(new ArrayList<>(cur));
            return;
        }

        for(int next : graph[node]){
            cur.add(next);
            dfs(cur, n, graph, next, answer);
            cur.remove(cur.size() - 1);
        }
    }
}