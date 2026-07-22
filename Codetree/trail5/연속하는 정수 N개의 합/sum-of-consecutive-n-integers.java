import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, int m, int[] nums) {
        int answer = 0;
        int left = 0;
        int sum = 0;
        for(int right = 0; right < n; right++) {
            sum += nums[right];

            while(sum > m){
                sum -= nums[left];
                left++;
            }

            if(sum == m){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(N, M, A));
    }
}
