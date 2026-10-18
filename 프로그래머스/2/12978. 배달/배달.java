import java.util.*;

class Edge{
    int node;
    int cost;
    
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        
        pq.offer(new Edge(1, 0));
        distance[1] = 0;
        
        Map<Integer, List<Edge>> graph = new HashMap<>();
        
        for(int[] r : road){
            int u = r[0];
            int v = r[1];
            int w = r[2];
            
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, w));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, w)); 

        }
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(distance[cur.node] < cur.cost) continue;
            
            for(Edge next : graph.get(cur.node)){
                int newDist = distance[cur.node] + next.cost;
                
                if(newDist < distance[next.node]){
                    pq.offer(new Edge(next.node, newDist));
                    distance[next.node] = newDist;
                }
            }
        }
        
        for(int i = 1; i <= N; i++){
            if(distance[i] <= K) answer++;
        }
        
        return answer;
    }
}