import java.io.*;
import java.util.*;

public class Main {
    List<int[]> result = new ArrayList<>();
    int[] list;

    public void solution(int k, int n) {
        list = new int[n];
        backtrack(0, k, n);

        StringBuilder sb = new StringBuilder();
        for (int[] arr : result) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i < arr.length - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private void backtrack(int depth, int k, int n) {
        if(depth == n) {
            result.add(list.clone());
            return;
        }

        for(int i = 1; i <= k; i++) {
            list[depth] = i;
            backtrack(depth+1, k, n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Main main = new Main();
        main.solution(K, N);
    }
}
