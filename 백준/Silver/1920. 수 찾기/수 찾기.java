import java.util.*;
import java.io.*;

/*
    BAEKJOON 1920번 수 찾기
    https://www.acmicpc.net/problem/1920
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int data = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int left = 0;
            int right = N-1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] < data){
                    left = mid + 1;
                }
                else if(nums[mid] > data){
                    right = mid - 1;
                }
                else{
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
