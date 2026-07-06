import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int[] nums, int[] targets) {

        int m = targets.length;
        int[] answer = new int[m];

        for(int i = 0; i < m; i++){
            int target = targets[i];
            int low = lowerBound(nums, target);
            int high = upperBound(nums, target);

            answer[i] = high - low;
        }

        return answer;
    }
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int midIdx = nums.length;

        while (left <= right) {
            int mid =(left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
                midIdx = Math.min(midIdx, mid);
            }
            else left = mid + 1;
        }

        return midIdx;
    }
    private int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int midIdx = nums.length;

        while (left <= right) {
            int mid =(left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                midIdx = Math.min(midIdx, mid);
            }
            else left = mid + 1;
        }

        return midIdx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        for(int j = 0; j < M; j++){
            B[j] = Integer.parseInt(br.readLine());
        }

        Main main = new Main();
        int[] answer = main.solution(A, B);
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
