import java.util.*;

class Solution {
    final int INF = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Edge>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] fare : fares){
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];
            
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        int[] distsA = dijkstra(graph, a, n);
        int[] distsB = dijkstra(graph, b, n);
        int[] dists = dijkstra(graph, s, n);
        
        int minCost = INF;
        for(int i = 1; i <= n; i++){
            int sum = distsA[i] + distsB[i] + dists[i];
            minCost = Math.min(minCost, sum);
        }
        
        return minCost;
    }
    class Edge{
        int node;
        int cost;
        
        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    
    public int[] dijkstra(List<List<Edge>> graph, int start, int n){
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.offer(new Edge(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            for(Edge next : graph.get(cur.node)){
                int nextDist = distance[cur.node] + next.cost;
                if(nextDist < distance[next.node]){
                    pq.add(new Edge(next.node, nextDist));
                    distance[next.node] = nextDist;
                }
            }
        }
        return distance;
        
    }
    
}