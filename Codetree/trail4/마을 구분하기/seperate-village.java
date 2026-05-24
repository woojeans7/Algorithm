import java.io.*;
import java.util.*;

public class Main {
    public void solution(int n, int[][] graph){
        boolean[][] visited = new boolean[n][n];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    int count = dfs(i, j, n, graph, visited);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for(int num : list){
            System.out.println(num);
        }

    }
    private int dfs(int r, int c, int n, int[][] graph, boolean[][] visited){
        visited[r][c] = true;
        int count = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                if(!visited[nr][nc] && graph[nr][nc] == 1){
                    count += dfs(nr, nc, n, graph, visited);
                }
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        main.solution(N, graph);
    }
}