import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n, List<int[]> list) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) ->
                a[1]));
        for(int[] pos : list) {
            pq.offer(pos);
        }

        int lastEnd = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int start = cur[0];
            int end = cur[1];

            if(lastEnd < start) {
                lastEnd = end;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new int[]{l, r});
        }

        Main main = new Main();
        System.out.println(main.solution(N, list));
    }
}
