import java.util.*;
import java.io.*;

public class Main {
    public int solution(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, check(i, j, grid));
            }
        }

        return answer;
    }
    private int check(int row, int col, int[][] grid) {
        int max = 0;

        if(col + 2 < grid[0].length){
            max = Math.max(max, grid[row][col] + grid[row][col + 1] + grid[row][col + 2]);
        }

        if(row + 2 < grid.length){
            max = Math.max(max, grid[row][col] + grid[row + 1][col] + grid[row + 2][col]);
        }

        if(row + 1 < grid.length && col + 1 < grid[0].length){
            max = Math.max(max, grid[row][col] + grid[row][col + 1] + grid[row + 1][col]);
            max = Math.max(max, grid[row][col] + grid[row][col + 1] + grid[row + 1][col + 1]);
            max = Math.max(max, grid[row][col] + grid[row + 1][col] + grid[row + 1][col + 1]);
            max = Math.max(max, grid[row][col + 1] + grid[row + 1][col] + grid[row + 1][col + 1]);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(m.solution(grid));

    }
}
