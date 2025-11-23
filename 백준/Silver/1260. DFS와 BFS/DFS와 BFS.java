import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 0; i <= N; i++){
            graph.get(i).sort(Comparator.naturalOrder());
        }

        boolean[] visited = new boolean[N+1];
        dfs(graph, V, visited);
        visited = new boolean[N+1];
        System.out.println();
        bfs(graph, V, visited);
    }
    public static void dfs(List<List<Integer>> graph, int V, boolean[] visited){
        visited[V] = true;
        System.out.print(V + " ");

        for(int next : graph.get(V)){
            if(!visited[next]){
                dfs(graph, next, visited);
            }
        }
    }
    public static void bfs(List<List<Integer>> graph, int V, boolean[] visited){
        visited[V] = true;

        Queue<Integer> q = new LinkedList<>();

        q.add(V);
        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");

            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
