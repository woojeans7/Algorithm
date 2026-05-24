import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums) {

        int answer = 1;
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                count++;
                answer = Math.max(answer, count);
            }
            else count = 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
