import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums, int[] line) {
        int answer = 0;

        Arrays.sort(nums);
        answer = upperBound(nums, line[1]) - lowerBound(nums, line[0]);

        return answer;
    }
    private int upperBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > x) {
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }
    private int lowerBound(int[] nums, int x) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= x) {
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
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

        Main main = new Main();
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(main.solution(A, new int[]{x, y})).append('\n');
        }

        System.out.println(sb.toString());
    }
}
