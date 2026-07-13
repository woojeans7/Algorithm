import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int node;
    int cost;

    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }

}
public class Main {
    public int[] solution(int n, int m, int k, List<List<Edge>> graph) {

        int INF = Integer.MAX_VALUE;
        int[] distance =  new int[n + 1];
        Arrays.fill(distance, INF);

        Queue<Edge> pq = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.cost)
        );
        pq.offer(new Edge(k, 0));
        distance[k] = 0;

        while (!pq.isEmpty()){
            Edge e = pq.poll();

            if(distance[e.node] < e.cost) continue;

            for(Edge next : graph.get(e.node)){
                int newCost = distance[e.node] + next.cost;
                if(newCost < distance[next.node]){
                    pq.offer(new Edge(next.node, newCost));
                    distance[next.node] = newCost;
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Edge(y, w));
            graph.get(y).add(new Edge(x, w));
        }

        Main main = new Main();
        int[] answer = main.solution(N, M, K, graph);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i] == Integer.MAX_VALUE ? -1 : answer[i]).append('\n');
        }
        System.out.print(sb);
    }
}
