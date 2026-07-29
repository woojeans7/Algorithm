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
    public String solution(int n, List<List<Edge>> graph, int[] pos) {
        int end = pos[0];
        int start = pos[1];

        int[] distance =  new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(cur.dist > distance[cur.node]) continue;

            for(Edge next : graph.get(cur.node)) {
                int newDist = distance[cur.node] + next.dist;
                if(newDist < distance[next.node]) {
                    distance[next.node] = newDist;
                    pq.offer(new Edge(next.node, newDist));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(distance[end]).append("\n");

        int current = end;
        while(current != start) {
            sb.append(current).append(" ");
            int next = -1;
            for(Edge e : graph.get(current)) {
                if(distance[e.node] + e.dist == distance[current]) {
                    if(next == -1 || e.node < next) {
                        next = e.node;
                    }
                }
            }
            current = next;
        }
        sb.append(start);

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        int[] pos = new int[2];
        st = new StringTokenizer(br.readLine());
        pos[0] = Integer.parseInt(st.nextToken());
        pos[1] = Integer.parseInt(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(N,graph, pos));
    }
}
