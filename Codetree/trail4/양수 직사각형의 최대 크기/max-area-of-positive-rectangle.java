import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int m, int[][] board) {

        // 구간합 구하기
        int[][] prefix =  new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int val = board[i-1][j-1] > 0 ? 1 : 0;
                prefix[i][j] = val + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        int max = 0;
        for(int r1 = 1; r1 <= n; r1++){
            for(int c1 = 1; c1 <= m; c1++){
                for(int r2 = 1; r2 <= n; r2++){
                    for(int c2 = 1; c2 <= m; c2++){
                        int area = calcMaxArea(prefix, r1, c1, r2, c2);
                        max = Math.max(area, max);
                    }
                }
            }
        }

        return max != 0 ? max : -1;
    }
    public int calcMaxArea(int[][] prefix, int x1, int y1, int x2, int y2) {
        int sum = prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
        int expectedArea = (x2 - x1 + 1) * (y2 - y1 + 1); // 직사각형의 칸 수

        return (sum == expectedArea) ? expectedArea : 0;
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

