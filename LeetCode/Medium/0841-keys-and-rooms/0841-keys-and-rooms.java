class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);
        if(visited.size()==rooms.size())
        {
            return true;
        }
        else {
            return false;
        }
        
    }
    void dfs(List<List<Integer>> rooms, Set<Integer> visited, int curVertex) {
        visited.add(curVertex);
        for (int nextVertex : rooms.get(curVertex)) {
            if (!visited.contains(nextVertex)) {
                dfs(rooms, visited, nextVertex);
            }
        }
    }
}