import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] board, int[] start, int[] end) {
        int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = {-1, -2, -2, -1, 1, 2, 2, 1};

        int n = board.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dist =  cur[2];

            if(row == end[0] && col == end[1]){
                return dist;
            }

            for(int i = 0; i < 8; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken()) - 1;
        int c1 = Integer.parseInt(st.nextToken()) - 1;
        int r2 = Integer.parseInt(st.nextToken()) - 1;
        int c2 = Integer.parseInt(st.nextToken()) - 1;

        int[][] A = new int[N][N];

        Main main = new Main();
        System.out.println(main.solution(A, new int[]{r1, c1}, new int[]{r2, c2}));
    }
}
