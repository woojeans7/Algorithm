import java.util.*;
import java.io.*;

/*
    BAEKJOON 10026번 적록색약
    https://www.acmicpc.net/problem/10026
*/

public class Main {
    static int count;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        int R = 0;
        int G = 0;
        int B = 0;
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'R' && !visited[i][j]){
                    bfs(board, i, j, 'R', visited);
                    R++;
                }
                else if(board[i][j] == 'G' && !visited[i][j]){
                    bfs(board, i, j, 'G', visited);
                    G++;
                }
                else if(board[i][j] == 'B' && !visited[i][j]){
                    bfs(board, i, j, 'B', visited);
                    B++;
                }
            }
        }
        int total = R + G + B;
        StringBuilder sb = new StringBuilder();
        sb.append(total).append(" ");

        visited = new boolean[n][n];
        R = 0;
        B = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != 'B'){
                    board[i][j] = 'A';
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'B' && !visited[i][j]){
                    bfs(board, i, j, 'B', visited);
                    B++;
                }
                else if(board[i][j] == 'A' && !visited[i][j]){
                    bfs(board, i, j, 'A', visited);
                    R++;
                }
            }
        }
        total = R + B;
        sb.append(total);

        System.out.println(sb);


    }
    public static void bfs(char[][] board, int x, int y, char c, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(!visited[nr][nc] && board[nr][nc] == c){
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
