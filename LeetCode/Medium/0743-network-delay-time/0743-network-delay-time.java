class Edge{
    int node;
    int cost;

    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // 그래프 초기화
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
        
        // 다익스트라 구현
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        int[] distance = new int[n + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);

        pq.add(new Edge(k, 0));
        distance[k] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(distance[cur.node] < cur.cost) continue;

            for(Edge next : graph.get(cur.node)){
                int newDist = cur.cost + next.cost;

                if(newDist < distance[next.node]){
                    pq.add(new Edge(next.node, newDist));
                    distance[next.node] = newDist;
                }
            }
        }

        // k 노드에서 신호를 보낼 때 최소 시간
        int answer = 0;
        for(int i = 1; i <= n; i++){
            answer = Math.max(distance[i], answer);
        }

        return answer == INF ? -1 : answer;
    }
}