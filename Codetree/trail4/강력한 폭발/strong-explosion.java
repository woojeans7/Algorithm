import java.io.*;
import java.util.*;

public class Main {
    int max = 0;
    List<int[]> bombs = new ArrayList<>();

    int[][] dxs = {
            {-2, -1, 1, 2},
            {-1, 1, 0, 0},
            {-1, -1, 1, 1}
    };
    int[][] dys = {
            {0, 0, 0, 0},
            {0, 0, -1, 1},
            {-1, 1, -1, 1}
    };

    public int solution(int n, int[][] board){
        int answer = 0;

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    bombs.add(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[n][n];
        backtracking(0, n, visited);

        return max;
    }
    private void backtracking(int idx, int n, boolean[][] visited){
        if(idx == bombs.size()){
            int count = countArea(visited, n);
            max = Math.max(max, count);
            return;
        }

        int[] cur = bombs.get(idx);

        for(int i = 0; i < 3; i++){
            List<int[]> marked = new ArrayList<>();
            if(!visited[cur[0]][cur[1]]){
                visited[cur[0]][cur[1]] = true;
                marked.add(cur);
            }

            for(int j = 0; j < 4; j++){
                int nx = cur[0] + dxs[i][j];
                int ny = cur[1] + dys[i][j];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        marked.add(new int[]{nx, ny});
                }
            }

            backtracking(idx+1, n, visited);

            for(int[] pos : marked){
                visited[pos[0]][pos[1]] = false;
            }
        }
    }
    private int countArea(boolean[][] visited, int n){
        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(N, board));
    }
}