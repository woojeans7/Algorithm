class Edge implements Comparable<Edge>{
    int node;
    int cost;

    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.get(u).add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] distance = new int[n+1];
        final int INF = Integer.MAX_VALUE;
        
        Arrays.fill(distance, INF);
        pq.add(new Edge(k, 0));
        distance[k] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(cur.cost > distance[cur.node]) continue;

            for(Edge next : graph.get(cur.node)){
                if(distance[next.node] > cur.cost + next.cost){
                    pq.offer(new Edge(next.node, cur.cost + next.cost));
                    distance[next.node] = cur.cost + next.cost;
                }
            }
        }
        
        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            maxTime = Math.max(maxTime, distance[i]);
        }

        return (maxTime == INF)? -1 : maxTime;
    }
}