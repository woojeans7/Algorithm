import java.io.*;
import java.util.*;

public class Main {
    int answer = 0;
    public int solution(int n, int m, int[] nums) {
        backtrack(0, 0, 0, m, nums);
        return answer;
    }
    private void backtrack(int depth, int start, int count, int m, int[] nums){

        if(depth == m){
            answer = Math.max(answer, count);
            return;
        }

        for(int i = start; i < nums.length; i++){
            count ^= nums[i];
            backtrack(depth + 1, i + 1, count, m, nums);
            count ^= nums[i];
        }
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
