import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int node;
    int dist;

    public Edge(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
    @Override
    public int compareTo(Edge o) {
        return this.dist - o.dist;
    }
}
public class Main {
    public int solution(int n, List<List<Edge>> graph) {
        int INF = Integer.MAX_VALUE;
        int[] distance =  new int[n + 1];
        Arrays.fill(distance, INF);

        // 시작점을 n으로 해서 모든 노드까지 최단거리를 구함
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(n, 0));
        distance[n] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if(distance[e.node] < e.dist) continue;

            // 다음 노드 예약
            for(Edge next : graph.get(e.node)) {
                int newDist = distance[e.node] + next.dist;
                if(newDist < distance[next.node]) {
                    pq.offer(new Edge(next.node, newDist));
                    distance[next.node] = newDist;
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(distance[i] != INF && distance[i] > max) {
                max = distance[i];
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.get(b).add(new Edge(a, d));
        }

        Main main = new Main();
        System.out.println(main.solution(N, graph));
    }
}
