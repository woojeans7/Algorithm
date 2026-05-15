import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n) {
        int max = n + 1;
        int[] distance =  new int[max + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        distance[n] = 0;

        while (!queue.isEmpty()) {
            int cur =  queue.poll();

            if(cur == 1) return distance[cur];

            int[] next = {cur - 1, cur + 1, cur / 2, cur / 3};
            boolean[] valid = {cur - 1 >= 1, cur + 1 <= max, cur % 2 == 0, cur % 3 == 0};

            for(int i = 0; i < 4; i++) {
                if(valid[i]) {
                    int nx = next[i];
                    if(distance[nx] == -1) {
                        distance[nx] = distance[cur] + 1;
                        queue.offer(nx);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Main main = new Main();
        System.out.println(main.solution(N));
    }
}
