import java.io.*;
import java.util.*;

public class Main {
    int m;
    int c;
    int[][] rooms;
    public int solution(int n, int m, int c, int[][] rooms) {
        this.rooms = rooms;
        this.m = m;
        this.c = c;

        int answer = 0;

        for(int r1 = 0; r1 < n; r1++) {
            for(int r2 = r1; r2 < n; r2++) {
                for(int s1 = 0; s1 + m <= n; s1++){
                    for(int s2 = 0; s2 + m <= n; s2++){
                        if(r1 != r2 || s2 >= s1 + m || s1 >= s2 + m){
                            answer = Math.max(answer, gain(r1, s1) + gain(r2, s2));
                        }
                    }
                }
            }
        }
        return answer;
    }
    private int gain(int row, int startCol){
        int[] dp = new int[c + 1];

        for(int col = startCol; col < startCol + m; col++){
            int w = rooms[row][col];
            for(int cap = c; cap >= w; cap--){
                dp[cap] = Math.max(dp[cap], dp[cap - w] + w * w);
            }
        }

        return dp[c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(N, M, C, A));
    }
}
