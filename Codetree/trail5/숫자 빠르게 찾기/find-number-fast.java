import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums, int target) {
        int n = nums.length;

        int left = 1;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int T = Integer.parseInt(br.readLine());
            sb.append(main.solution(A, T)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
