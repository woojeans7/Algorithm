import java.io.*;
import java.util.*;

public class Main {
    public String solution(int[] board, int m) {
        List<Integer> current = new ArrayList<>();
        for (int v : board) current.add(v);

        while (true) {
            List<Integer> next = new ArrayList<>();
            boolean removedAny = false;
            int n = current.size();
            int i = 0;
            while (i < n) {
                int j = i;
                while (j < n && current.get(j).equals(current.get(i))) j++;
                int runLen = j - i;
                if (runLen >= m) {
                    removedAny = true; // 이 구간은 통째로 터뜨림 (next에 안 넣음)
                } else {
                    for (int k = i; k < j; k++) next.add(current.get(k));
                }
                i = j;
            }
            current = next;
            if (!removedAny) break; // 더 이상 터질 게 없으면 종료
        }

        StringBuilder sb = new StringBuilder();
        sb.append(current.size()).append("\n");
        for (int v : current) sb.append(v).append("\n");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Main main = new Main();
        System.out.println(main.solution(A, M));
    }
}
