import java.util.*;
import java.io.*;

/*
    BAEKJOON 13023번 ABCDE
    https://www.acmicpc.net/problem/13023
*/

public class Main {
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            graph.get(X).add(Y);
            graph.get(Y).add(X);
        }

        flag = false;
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++){
            dfs(i, 1, graph,visited);
            if(flag) break;
        }

        System.out.println(flag ? "1" : "0");
    }
    public static void dfs(int current, int depth, List<List<Integer>> graph, boolean[] visited){

        visited[current] = true;

        if(depth == 5){
            flag = true;
            return;
        }
        for(int next: graph.get(current)){
            if(!visited[next]){
                dfs(next, depth + 1, graph, visited);
            }
        }

        visited[current] = false;
    }
}