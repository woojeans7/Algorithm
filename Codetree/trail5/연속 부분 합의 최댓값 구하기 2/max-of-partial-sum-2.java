import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int[] nums) {
        int answer = nums[0];
        int sum = nums[0];

        for(int i = 1; i < n; i++){
            sum = Math.max(sum + nums[i], nums[i]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, A));
    }
}
