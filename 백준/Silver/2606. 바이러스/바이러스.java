import java.util.*;
import java.io.*;

/*
    BAEKJOON 2606번 바이러스
    https://www.acmicpc.net/problem/2606
*/

public class Main {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 네트워크 수

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(0, new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            graph.add(i, new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        Set<Integer> visited = new HashSet<>();
        dfs(graph, 1, visited);

        System.out.println(count);
    }
    private static void dfs(List<List<Integer>> graph, int start, Set<Integer> visited) {
        visited.add(start);

        for (int i : graph.get(start)) {
            if (!visited.contains(i)) {
                count++;
                dfs(graph, i, visited);
            }
        }
    }
}
