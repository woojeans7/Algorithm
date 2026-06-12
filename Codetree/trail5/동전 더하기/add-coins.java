import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] coins, int k) {
        int n = coins.length;
        Arrays.sort(coins);

        int count = 0;
        for(int i = n-1; i >= 0; i--) {
            count += k / coins[i];
            k %= coins[i];
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        Main main = new Main();
        System.out.println(main.solution(C, K));
    }
}
