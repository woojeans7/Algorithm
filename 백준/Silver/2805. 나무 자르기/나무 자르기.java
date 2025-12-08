import java.util.*;
import java.io.*;

/*
    BAEKJOON 2805번 나무 자르기
    https://www.acmicpc.net/problem/2805
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            max = Math.max(max, tree);
        }

        long left = 1;
        long right = max;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for(int i = 0; i < N; i++) {
                // mid만큼 잘랐을 때 나머지 길이의 합
                sum += Math.max(0, trees[i] - mid);
            }

            // 합의 크기가 최소가 되어야 최대로 자른거임
            // 크면 만족
            if(sum >= M) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        System.out.println(ans);
    }
}
