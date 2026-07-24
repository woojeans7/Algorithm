import java.util.*;

class Edge implements Comparable<Edge>{
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Solution {
    final int INF = 1_000_000_000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer,List<Edge>> graph = new HashMap<>();
        for(int i = 0; i <= n; i++){
            graph.put(i,new ArrayList<>());
        }

        for(int[] fare : fares){
            int u = fare[0];
            int v = fare[1];
            int w = fare[2];

            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }

        int[] distS = dijkstra(graph, s, n);
        int[] distA = dijkstra(graph, a, n);
        int[] distB = dijkstra(graph, b, n);

        int minCost = INF;
        for(int i = 0; i <= n; i++){
            if (distS[i] == INF || distA[i] == INF || distB[i] == INF) continue;

            int sum = distS[i] + distA[i] + distB[i];
            minCost = Math.min(minCost, sum);
        }

        return minCost;
    }
    private int[] dijkstra(Map<Integer,List<Edge>> graph, int start, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance,INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(distance[cur.node] < cur.cost) continue;

            for(Edge next : graph.get(cur.node)){
                int dist = distance[cur.node] + next.cost;
                if(dist < distance[next.node]){
                    distance[next.node] = dist;
                    pq.offer(new Edge(next.node,dist));
                }
            }
        }
        return distance;
    }
}
