class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();

        dfs(rooms, 0, visited);

        // 모든 방을 방문했을 때 true 반환
        if(visited.size() == rooms.size()){
            return true;
        }
        else return false;
    }
    public void dfs(List<List<Integer>> rooms, int cur, Set<Integer> visited){
        // 1. 현재 노드 방문 처리
        visited.add(cur);

        // 2. 다음 노드 예약
        for(int i : rooms.get(cur)){
            if(!visited.contains(i)){
                dfs(rooms, i, visited);
            }
        }
    }
}