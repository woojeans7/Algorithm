import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int len = sources.length;
        
        int[] answer = new int[len];
        
        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // 소스만큼 BFS 호출
        for(int i = 0; i < len; i++){
            answer[i] = bfs(sources[i], destination, graph);
        }
        return answer;
    }
    private int bfs(int start, int destination, List<List<Integer>> graph){
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];
        
        // 시작점 초기화
        queue.add(new int[]{start, 0});
        visited[start] = true;
        
        // 탐색 시작
        while(!queue.isEmpty()){
            
            int[] cur = queue.poll();
            
            int position = cur[0];
            int distance = cur[1];
            
            if(position == destination) return distance;
            
            for(int next : graph.get(position)){
                if(!visited[next]){
                    queue.offer(new int[]{next, distance + 1});
                    visited[next] = true;
                }
            }
        }
        
        return -1;
    }
}