class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            dfs(isConnected, i, visited, n);
            count++;
        }

        return count;
    }
    private void dfs(int[][] graph, int cur, boolean[] visited, int n){
        visited[cur] = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[cur][i] == 1) {
                dfs(graph, i, visited, n);
            }
        }
    }
}