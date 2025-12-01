import java.util.*;
import java.io.*;

/*
    BAEKJOON 2667번 단지번호붙이기
    https://www.acmicpc.net/problem/2667
*/

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] line = new String[n];
        for(int i = 0; i < n; i++){
            line[i] = br.readLine();
        }

        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(line[i].split("")[j]);
            }
        }

        //System.out.println(Arrays.deepToString(board));

        boolean[][] visited = new boolean[n][n];

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    int size = bfs(board, i, j, visited);
                    list.add(size);
                }
            }
        }
        list.sort(Comparator.naturalOrder());

        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static int bfs(int[][] board, int x, int y, boolean[][] visited){

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(!visited[nr][nc] && board[nr][nc] == 1){
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
