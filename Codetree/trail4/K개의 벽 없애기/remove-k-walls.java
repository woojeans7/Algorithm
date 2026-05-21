import java.io.*;
import java.util.*;

public class Main {
    int n;
    int answer = -1;
    public int solution(int[][] grid, int k, int[] start, int[] end, List<int[]> walls) {
        n = grid.length;
        boolean[] removed = new boolean[walls.size()];
        dfs(removed, 0, 0, k, grid, start, end, walls);
        return answer;
    }
    private void dfs(boolean[] removed, int idx, int count, int k, int[][] grid, int[] start, int[] end, List<int[]> walls) {

        if(count == k || idx == walls.size()){
            int result = bfs(removed, grid, start, end, walls);
            if(result != -1){
                answer = (answer == -1) ? result : Math.min(answer, result);
            }
            return;
        }

        removed[idx] = true;
        dfs(removed, idx + 1, count + 1, k, grid, start, end, walls);

        removed[idx] = false;
        dfs(removed, idx + 1, count, k, grid, start, end, walls);


    }
    private int bfs(boolean[] removed, int[][] grid, int[] start, int[] end, List<int[]> walls) {
        // 제거된 벽 임시 반영
        for (int i = 0; i < walls.size(); i++) {
            if (removed[i]) grid[walls.get(i)[0]][walls.get(i)[1]] = 0;
        }

        Queue<int[]> queue = new LinkedList<>();

        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(distance[i], -1);

        queue.offer(start);
        distance[start[0]][start[1]] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            if(row == end[0] && col == end[1]) {
                for (int i = 0; i < walls.size(); i++) {
                    if (removed[i]) grid[walls.get(i)[0]][walls.get(i)[1]] = 1;
                }
                return distance[row][col];
            }

            for(int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    if(distance[nr][nc] == -1 && grid[nr][nc] == 0) {
                        distance[nr][nc] = distance[row][col] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        for (int i = 0; i < walls.size(); i++) {
            if (removed[i]) grid[walls.get(i)[0]][walls.get(i)[1]] = 1;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K =  Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        List<int[]> walls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] == 1) walls.add(new int[]{i, j});
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] S = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};

        st = new StringTokenizer(br.readLine());
        int[] E = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};


        Main main = new Main();
        System.out.println(main.solution(A, K, S, E, walls));
    }
}
