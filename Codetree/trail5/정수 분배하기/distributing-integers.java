import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums, int m) {
        int answer = 0;

        Arrays.sort(nums);
        int low = 1, high = nums[nums.length - 1];

        while(low <= high){
            int mid = (low + high) / 2;

            if(canDivide(nums, m, mid)){
                answer = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return answer;
    }
    private boolean canDivide(int[] nums, int m, int param){
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            count += nums[i] / param;
        }

        return count >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Main main = new Main();
        System.out.println(main.solution(A, M));
    }
}