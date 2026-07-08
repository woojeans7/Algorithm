import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums, int sum) {
        int answer = Integer.MAX_VALUE;
        int n = nums.length;

        int total = 0;
        int right = 0;
        for(int left = 0; left < n; left++) {
            while(right < n && total < sum) {
                total += nums[right++];
            }

            if(total >= sum) answer = Math.min(answer, right - left);
            total -= nums[left];
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(A, S));
    }
}
