import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] segments) {
        Arrays.sort(segments, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        int count = 0;
        int lastEnd = -1;

        for (int[] seg : segments) {
            int start = seg[0];
            int end   = seg[1];

            if (start > lastEnd) {
                count++;
                lastEnd = end;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] segments = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            segments[i][0] = Integer.parseInt(st.nextToken());
            segments[i][1] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(segments));
    }
}
