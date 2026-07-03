import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] students) {
        int answer = 0;
        int n = students.length;

        // 축구팀 11명, 야구팀 9명 뽑아서 능력합이 최대가 되도록
        // dp[i][j]는 축구 i명, 야구 j명 뽑았을 때까지 최대 합
        int[][] dp = new int[12][10];
        for(int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);

        dp[0][0] = 0;

        // 각 학생 k마다 3가지 선택
        for(int k = 0; k < n; k++) {
            for(int i = 11; i >= 0; i--) {
                for(int j = 9; j >= 0; j--) {
                    if(dp[i][j] == Integer.MIN_VALUE) continue;

                    if(i + 1 <= 11)
                        dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + students[k][0]);
                    if(j + 1 <= 9)
                        dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j] + students[k][1]);
                }
            }
        }

        return dp[11][9];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] H = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            H[i][0] = Integer.parseInt(st.nextToken());
            H[i][1] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(H));
    }
}
