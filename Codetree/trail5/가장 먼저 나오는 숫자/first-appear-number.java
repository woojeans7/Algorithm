import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[] nums, int query) {
        //오름차순으로 정렬되어있는 N개의 수가 주어집니다.
        // 이후 M개의 질의가 주어지며 각 질의마다 하나의 수 x가 주어졌을 때,
        // 주어진 x 중에서 최초로 등장하는 위치를 출력하는 프로그램을 작성해보세요.
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (query <= nums[mid]) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        // left가 배열 범위 내에 있고, 값이 일치하는지 확인
        if (left < nums.length && nums[left] == query) {
            return left + 1;
        }
        
        return -1;
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

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int Q = Integer.parseInt(st.nextToken());
            System.out.println(main.solution(A, Q));
        }

    }
}
