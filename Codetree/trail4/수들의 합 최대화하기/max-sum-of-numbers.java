import java.io.*;
import java.util.*;

public class Main {
    int answer = 0;
    public int solution(int n, int[][] grid) {
        boolean[] selected = new boolean[n];
        backtrack(0, n, grid, selected,0);
        return answer;
    }
    private void backtrack(int row, int n, int[][] grid, boolean[] selected, int count) {
        if(row == n){
            answer = Math.max(answer, count);
            return;
        }

        for(int i = 0; i < n; i++){
            if(!selected[i]){
                selected[i] = true;
                backtrack(row+1, n, grid, selected, count + grid[row][i]);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(N, A));
    }
}
