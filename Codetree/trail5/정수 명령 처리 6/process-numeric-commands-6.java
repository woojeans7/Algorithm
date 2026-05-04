import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        // 최대 힙: Collections.reverseOrder()로 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    pq.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pq.poll()).append('\n');
                    break;
                case "size":
                    sb.append(pq.size()).append('\n');
                    break;
                case "empty":
                    sb.append(pq.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "top":
                    sb.append(pq.peek()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}