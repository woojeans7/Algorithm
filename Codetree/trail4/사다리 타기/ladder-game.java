import java.io.*;
import java.util.*;

public class Main {
    int answer = Integer.MAX_VALUE;
    int[] original;
    public int solution(int n, int m, int[][] ladder) {
        int[][] board = new int[16][n+1];
        for(int i = 0; i < m; i++){
            int a = ladder[i][0];
            int b = ladder[i][1];
            board[b][a] = 1;
        }
        original = ladder_game(n, board);
        boolean[] selected = new boolean[m];
        backtrack(0, 0, selected, n, m, ladder);

        return answer;
    }
    private int[] ladder_game(int n, int[][] board){
        int[] result = new int[n+1];

        // 사다리 순서대로 선택
        for(int i = 1; i <= n; i++){
            int col = i;
            for(int row = 1; row <= 15; row++){
                // 오른쪽으로 이동
                if(board[row][col] == 1){
                    col++;
                }
                // 왼쪽으로 이동
                else if(board[row][col-1] == 1){
                    col--;
                }
            }
            result[i] = col;
        }

        return result;
    }
    private void backtrack(int idx, int count, boolean[] selected, int n, int m, int[][] ladder){
        if(idx == m){
            int[][] board = new int[16][n+1];

            for(int i = 0; i < m; i++){
                if(selected[i]){
                    int a = ladder[i][0];
                    int b = ladder[i][1];
                    board[b][a] = 1;
                }
            }

            int[] result = ladder_game(n, board);
            if (Arrays.equals(result, original)) {
                answer = Math.min(answer, count);
            }
            return;
        }


        selected[idx] = true;
        backtrack(idx + 1, count + 1, selected, n, m, ladder);

        selected[idx] = false;
        backtrack(idx + 1, count, selected, n, m, ladder);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ladder =  new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[i][0] = a;
            ladder[i][1] = b;
        }

        Main main = new Main();
        System.out.println(main.solution(N, M, ladder));
    }
}
