import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int n, int[] blocks, int s1, int e1, int s2, int e2) {
        List<Integer> list = new ArrayList<>();
        for(int block : blocks) list.add(block);

        list.subList(s1 - 1, e1).clear();
        list.subList(s2 - 1, e2).clear();

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            B[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int e1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s2 = Integer.parseInt(st.nextToken());
        int e2 = Integer.parseInt(st.nextToken());

        Main main = new Main();

        int[] answer = main.solution(N, B, s1, e1, s2, e2);
        System.out.println(answer.length);
        for(int block : answer) {
            System.out.println(block);
        }
    }
}
