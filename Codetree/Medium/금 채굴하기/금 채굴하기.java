import java.io.*;
import java.util.*;

class Main {
    public int solution(int[][] grid, int m) {
        int n  = grid.length;

        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int[] offset = {i, j};
                for(int k = 0; k <= 44; k++) {
                    int totalGold = calcGold(offset, k, n, grid);
                    int cost = (k * k) + ((k + 1) * (k + 1));
                    if(totalGold * m >= cost) {
                        answer = Math.max(answer, totalGold);
                    }
                }
            }
        }
        return answer;
    }
    private int calcGold(int[] offset, int k, int n, int[][] grid) {
        int gold = 0;
        for(int dx = -k; dx <= k; dx++) {
            for(int dy = -k; dy <= k; dy++) {
                if(Math.abs(dx) + Math.abs(dy) <= k) {
                    int cx = offset[0] + dx;
                    int cy = offset[1] + dy;
                    if(cx >= 0 && cx < n && cy >= 0 && cy < n) {
                        gold += grid[cx][cy];
                    }
                }
            }
        }
        return gold;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(main.solution(grid, M));
    }
}
