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
    final int INF = (int) 1e9;
    public int solution(int n, int s, int a, int b, int[][] fares) {

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares){
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];

            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }
        
        int[] distS = dijkstra(n, s, graph);
        int[] distA = dijkstra(n, a, graph);
        int[] distB = dijkstra(n, b, graph);
        
        int minCost = INF;
        for(int i = 1; i <= n; i++){
            if (distS[i] == INF || distA[i] == INF || distB[i] == INF) continue;

            int sum = distS[i] + distA[i] + distB[i];
            minCost = Math.min(minCost, sum);
        }
        
        return minCost;
    }
    private int[] dijkstra(int n, int start, List<List<Edge>> graph){
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.offer(new Edge(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(distance[cur.node] < cur.cost) continue;
            
            for(Edge next : graph.get(cur.node)){
                int dist = distance[cur.node] + next.cost;
                if(dist < distance[next.node]){
                    distance[next.node] = dist;
                    pq.offer(new Edge(next.node, dist));
                }
            }
        }
        return distance;
    }
}