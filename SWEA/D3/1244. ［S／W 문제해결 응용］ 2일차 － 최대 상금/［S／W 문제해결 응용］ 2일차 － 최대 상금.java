import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int answer;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            N = Integer.parseInt(st.nextToken());

            answer = 0;
            visited = new HashSet<>();

            dfs(0, S.toCharArray());

            sb.append("#" + t + " ").append(answer + "\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int depth, char[] arr) {
        String cur = new String(arr) + "," + depth;

        if(visited.contains(cur)) return;
        visited.add(cur);

        if (depth == N) {
            int result = Integer.parseInt(new String(arr));
            answer = Math.max(answer, result);
            return;
        }

        int L = arr.length;
        for (int i = 0; i < L - 1; i++) {
            for (int j = i + 1; j < L; j++) {
                swap(arr, i, j);
                dfs(depth + 1, arr);
                swap(arr, i, j);

            }
        }
    }
    public static void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}