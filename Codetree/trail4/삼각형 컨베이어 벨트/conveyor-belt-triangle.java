import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] left   = new int[N];
        int[] right  = new int[N];
        int[] bottom = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) left[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) right[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) bottom[i] = Integer.parseInt(st.nextToken());

        // 3N개짜리 원형 배열로 합치기
        int total = 3 * N;
        int[] belt = new int[total];
        for (int i = 0; i < N; i++) belt[i]         = left[i];
        for (int i = 0; i < N; i++) belt[N + i]     = right[i];
        for (int i = 0; i < N; i++) belt[2 * N + i] = bottom[i];

        // T번 시계 방향 shift = 뒤에서 T칸을 앞으로
        int shift = T % total;
        int[] result = new int[total];
        for (int i = 0; i < total; i++) {
            result[(i + shift) % total] = belt[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(result[i]).append(i < N-1 ? " " : "\n");
        for (int i = 0; i < N; i++) sb.append(result[N+i]).append(i < N-1 ? " " : "\n");
        for (int i = 0; i < N; i++) sb.append(result[2*N+i]).append(i < N-1 ? " " : "\n");

        System.out.print(sb);
    }
}