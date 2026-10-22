import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
       
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
        
        int[] distance = bfs(n, destination, graph);
        
        int[] answer = new int[sources.length];
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = distance[sources[i]];
        }
        
        return answer;
    }
    private int[] bfs(int n, int destination, List<List<Integer>> graph){
        
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        
        // 시작점 초기화
        queue.add(destination);
        distance[destination] = 0;
        
        // 탐색 시작
        while(!queue.isEmpty()){
            
            int cur = queue.poll();
            
            for(int next : graph.get(cur)){
                if(distance[next] == -1){
                    queue.offer(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }
        
        return distance;
    }
}