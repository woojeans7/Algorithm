import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int answer = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum <= k) {
                answer += (right - left);
                left++;
            }
            else right--;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Main main = new Main();
        System.out.println(main.solution(A, K));
    }
}
