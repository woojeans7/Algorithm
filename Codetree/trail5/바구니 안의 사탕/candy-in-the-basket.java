import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int k, int[][] candy) {
        int left = 0, sum = 0, answer = 0;

        Arrays.sort(candy, (a, b) -> a[1] - b[1]);

        for (int right = 0; right < n; right++) {
            sum += candy[right][0];
            while (candy[right][1] - candy[left][1] > 2*k) {
                sum -= candy[left][0];
                left++;
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            B[i][0] = Integer.parseInt(st.nextToken());
            B[i][1] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, K, B));
    }
}
