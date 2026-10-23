class Edge{
    int node;
    int cost;
    int k;

    public Edge(int node, int cost, int k){
        this.node = node;
        this.cost = cost;
        this.k = k;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 방향이 있는 그래프
        // src에서 dst까지 최소비용 구하기
        // 하지만 최대 k번까지 멈출 수 있음

        // 도착하기까지 카운트를 세서 k번까지 확장할 수 잇음

        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new Edge(to, price, 0));
        }
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        
        int maxEdge = k + 1;
        int INF = Integer.MAX_VALUE;
        int[][] distance = new int[n][maxEdge + 1];
        for(int[] d : distance) Arrays.fill(d, INF);
        
        pq.offer(new Edge(src, 0, 0));
        distance[src][0] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(distance[cur.node][cur.k] < cur.cost) continue;

            if(cur.node == dst) return cur.cost;
            // 이미 k번 도달했으면 다음 노드 탐색 스킵
            if(cur.k == maxEdge) continue;

            // 다음 노드 탐색
            for(Edge next : graph.get(cur.node)){
                int newDist = cur.cost + next.cost;
                int nk = cur.k + 1;

                if(newDist < distance[next.node][nk]){
                    pq.offer(new Edge(next.node, newDist, nk));
                    distance[next.node][nk] = newDist;
                }
            }
        }
        return -1;
    }
}