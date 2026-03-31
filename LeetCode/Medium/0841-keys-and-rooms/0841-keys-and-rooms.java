class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms, 0, visited);

        for(int i = 0; i < n; i++){
            if(!visited[i]) return false;
        }

        return true;
    }
    private void dfs(List<List<Integer>> rooms, int cur, boolean[] visited){
        visited[cur] = true;

        for(int next : rooms.get(cur)){
            if(!visited[next]){
                dfs(rooms, next, visited);
            }
        }
    }
}