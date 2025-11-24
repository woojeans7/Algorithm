import java.util.*;
import java.io.*;

public class Main {
    public static class Edge{
        int node;
        int cost;

        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" + node + ", " + cost + "}";
        }
    }

    static int distance = 0; // 거리 저장
    static int answer = 0; // 최대값 갱신 (정답)
    static int far = 1; // 먼 거리 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        List<List<Edge>> tree = new ArrayList<>();
        for(int v = 0; v <= V; v++){
            tree.add(new ArrayList<>());
        }


        for(int i = 0; i < V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            while(true){
                int node = Integer.parseInt(st.nextToken());
                if(node == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                tree.get(n).add(new Edge(node, cost));
            }

        }
        //System.out.println(tree);
        // 가장 먼 노드 찾기
        boolean[] visited = new boolean[V+1];
        dfs(tree, 1, visited);

        // 다시 초기화
        distance = 0;
        answer = 0;
        visited = new boolean[V+1];
        dfs(tree, far, visited);

        System.out.println(answer);

    }
    public static void dfs(List<List<Edge>> tree, int cur, boolean[] visited){
        visited[cur] = true;
        //System.out.println("cur : " + cur + ", depth : " + depth);
        //System.out.println("cur Distance : " + distance);

        if(distance > answer){
            answer = distance;
            far = cur;
        }

        for(Edge next : tree.get(cur)){
            if(!visited[next.node]){
                distance += next.cost;
                dfs(tree, next.node, visited);
                distance -= next.cost;
            }
        }
    }
}
