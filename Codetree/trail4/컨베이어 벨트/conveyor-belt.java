import java.io.*;
import java.util.*;

public class Main {
    public int[][] solution(int n, int t, int[] up, int[] down) {
        for(int step = 0; step < t; step++) {
            int temp = up[n-1];

            for(int i = n-1; i >= 1; i--) {
                up[i] = up[i-1];
            }
            up[0] = down[n-1];

            for(int i = n-1; i >= 1; i--) {
                down[i] = down[i-1];
            }
            down[0] = temp;
        }

        int[][] answer = new int[2][n];
        for(int i = 0; i < n; i++) {
            answer[0][i] = up[i];
            answer[1][i] = down[i];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] up = new int[N];
        int[] down = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            up[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            down[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();

        int[][] arr = main.solution(N, T, up, down);
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
