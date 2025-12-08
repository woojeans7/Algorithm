import java.sql.BatchUpdateException;
import java.util.*;
import java.io.*;

/*
    BAEKJOON 14940번 쉬운 최단거리
    https://www.acmicpc.net/problem/14940
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(distance[i], -1);
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row =  cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    if(distance[nr][nc] == -1 && map[nr][nc] != 0){
                        queue.offer(new int[]{nr, nc});
                        distance[nr][nc] = distance[row][col] + 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(distance[i][j] == -1 && map[i][j] == 0){
                    distance[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
	}
}
