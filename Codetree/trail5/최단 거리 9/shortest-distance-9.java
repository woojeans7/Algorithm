import java.io.*;
import java.util.*;

class Edge{
    int node;
    int dist;

    public Edge(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
public class Main {
    StringBuilder sb = new StringBuilder();
    public void solution(int n, List<List<Edge>> graph, int[] pos) {
        int start = pos[0];
        int end = pos[1];
        List<Integer> answer = new ArrayList<>();
        sb.append(dijkstra(graph, start, end, answer)).append("\n");
        for(int node : answer){
            sb.append(node).append(" ");
        }
        System.out.println(sb.toString());
    }
    private int dijkstra(List<List<Edge>> graph, int start, int end, List<Integer> answer){
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(a -> a.dist));
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(cur.node == end){
                int node = end;
                while(node != start){
                    answer.add(node);
                    for(Edge e : graph.get(node)){
                        // e.node가 "node로 오기 직전 노드"인지 확인
                        if(distance[e.node] + e.dist == distance[node]){
                            node = e.node;
                            break;
                        }
                    }
                }
                answer.add(start);
                Collections.reverse(answer); // end→start 순으로 쌓였으니 뒤집어서 start→end로
                return distance[cur.node];
            }

            if(distance[cur.node] < cur.dist) continue;

            for(Edge next : graph.get(cur.node)){
                int newDist = distance[cur.node] + next.dist;
                if(newDist < distance[next.node]){
                    distance[next.node] = newDist;
                    pq.offer(new Edge(next.node, newDist));
                }
            }
        }
        return -1;
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
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Edge(y, w));
            graph.get(y).add(new Edge(x, w));
        }

        st = new StringTokenizer(br.readLine());
        int[] pos = new int[2];
        pos[0] = Integer.parseInt(st.nextToken());
        pos[1] = Integer.parseInt(st.nextToken());

        Main main = new Main();
        main.solution(N, graph, pos);
    }
}
