class Solution {
    class Edge implements Comparable<Edge>{
        int node;
        int cost;
        Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other){
            return this.cost - other.cost;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // 그래프 변환 (인접리스트로 변환)
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int weight = time[2];

            graph.get(u).add(new Edge(v, weight));
        }

        // 다익스트라 알고리즘
        int INF = Integer.MAX_VALUE; // +1만해도 오버플로우가 발생하기 때문에 사용시 주의!
        int[] dists = new int[n+1];
        Arrays.fill(dists, INF);

        // 초기값 넣기
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(k, 0));
        dists[k] = 0;

        // k 노드에서 각 노드까지 가는 최소 비용
        while(!pq.isEmpty()){
            // 방문
            Edge cur = pq.poll();

            // 예약
            for(Edge next : graph.get(cur.node)){
                int nextDist = dists[cur.node] + next.cost; // cur까지 오는 비용 + 다음 노드까지의 비용
                // cur.node 통해서 가는 비용보다 비싸면 교체
                if(dists[next.node] > nextDist){
                    pq.offer(new Edge(next.node, nextDist));
                    dists[next.node] = nextDist;
                }
            }
        }
        // System.out.println(Arrays.toString(dists));


        // 최소 비용들 중에서 가장 큰 값 찾아서 return 하기.
        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            maxTime = Math.max(maxTime, dists[i]);
        }
        // 만약 도달 못한 노드가 하나라도 있으면 -1 return 
        if(maxTime == INF) return -1;

        return maxTime;
    }
}