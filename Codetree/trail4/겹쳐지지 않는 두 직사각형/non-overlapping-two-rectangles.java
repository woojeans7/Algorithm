import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int m, int[][] board) {
        int answer = 0;

        // 구간합 구하기
        int[][] prefix =  new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                prefix[i][j] = board[i-1][j-1]
                        + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        // 두 사각형 합 구하기
        int result = Integer.MIN_VALUE;
        for(int r1 = 0; r1 < n; r1++){
            for(int c1 = 0; c1 < m; c1++){
                for(int r2 = 0; r2 < n; r2++){
                    for(int c2 = 0; c2 < m; c2++){
                        if(r1 > r2 || c1 > c2) continue;
                        for(int r3 = 0; r3 < n; r3++){
                            for(int c3 = 0; c3 < m; c3++){
                                for(int r4 = 0; r4 < n; r4++){
                                    for(int c4 = 0; c4 < m; c4++){
                                        if(r3 > r4 || c3 > c4) continue;
                                        if(inRange(r1,c1,r2,c2,r3,c3,r4,c4)){
                                            int first = rectangleSum(prefix, r1+1, c1+1, r2+1, c2+1);
                                            int second = rectangleSum(prefix, r3+1, c3+1, r4+1, c4+1);
                                            result = Math.max(result, first + second);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
    private int rectangleSum(int[][] prefix, int r1, int c1, int r2, int c2) {
        return prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1];
    }
    private boolean inRange(int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {
        return (r2 < r3 || r1 > r4) || (c2 < c3 || c1 > c4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(N, M , board));
    }
}
