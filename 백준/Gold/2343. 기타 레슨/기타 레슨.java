import java.util.*;
import java.io.*;

/*
    BAEKJOON 2343번 기타 레슨
    https://www.acmicpc.net/problem/2343
*/

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] blueRay = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            blueRay[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        for(int i = 0; i < N; i++){
            left = Math.max(left, blueRay[i]);
            right += blueRay[i];
        }

        while(left <= right){
            int mid = (left + right)/2;
            int sum = 0;
            int count = 0;
            for(int i = 0; i < N; i++){
                if(sum + blueRay[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += blueRay[i];
            }
            if(sum != 0) count++;

            if(count > M) left = mid+1;
            else right = mid-1;
        }
        System.out.println(left);
    }
}
