import java.io.*;
import java.util.*;

public class Main {
    public void solution(int n, int m) {
        backtrack(1, new ArrayList<>(), n, m);
    }
    private void backtrack(int idx, List<Integer> cur, int n, int m) {
        if(cur.size() == m) {
            for(int i = 0; i < cur.size(); i++) {
                System.out.print(cur.get(i) + " ");
            }
            System.out.println();
        }

        for(int i = idx; i <= n; i++) {
            cur.add(i);
            backtrack(i + 1, cur, n, m);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Main main = new Main();
        main.solution(N, M);
    }
}
