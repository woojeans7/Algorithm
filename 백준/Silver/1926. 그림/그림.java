import java.util.*;
import java.io.*;

/*
    BAEKJOON 1926번 그림
    https://www.acmicpc.net/problem/1926
*/

public class Main {
    static int n;
    static int m;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n  = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[n][m];

        int paint = 0; // 그림의 개수
        count = 0;
        int width = 0; // 그림의 넓이
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && board[i][j] == 1){
                    bfs(board, i, j, visited);
                    paint++;
                    width = Math.max(width, count);
                }
            }
        }

        System.out.println(paint);
        System.out.println(width);

    }
    public static void bfs(int[][] board, int start, int end, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,end});
        visited[start][end] = true;
        count = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]){
                    if(board[nr][nc] == 1){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        count++; // 넓이 계산
                    }
                }
            }
        }
    }
}
