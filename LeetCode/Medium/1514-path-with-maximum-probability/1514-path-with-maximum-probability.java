class Solution {
    public class Edge{
        int node;
        double prob;
        
        public Edge(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 인접리스트 초기화
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        int i = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            double p = succProb[i];

            graph.get(u).add(new Edge(v, p));
            graph.get(v).add(new Edge(u, p));
            i++;
        }

        // 다익스트라
        double[] probability = new double[n];
        Arrays.fill(probability, 0.);

        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble((Edge e) -> e.prob).reversed());

        pq.offer(new Edge(start_node, 1.)); // 확률은 곱해야 하니까 1.0로 초기화
        probability[start_node] = 1.;
        
        while(!pq.isEmpty()){
            // 방문
            Edge cur = pq.poll();

            // 도착하면 종료
            if(cur.node == end_node) return probability[end_node];

            // 예약
            for(Edge next : graph.get(cur.node)){
                double nextProb = probability[cur.node] * next.prob;
                if(probability[next.node] < nextProb){
                    pq.offer(new Edge(next.node, nextProb));
                    probability[next.node] = nextProb;
                }
            }
        }

        return 0.;
    }
}