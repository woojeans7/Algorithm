import java.io.*;
import java.util.*;

public class Main {
    public void solution(int n) {
        boolean[] visited = new boolean[n+1];
        permutation(n, visited, new ArrayList<>());
    }
    private void permutation(int n, boolean[] visited, List<Integer> cur){
        if(cur.size() == n){
            for(int num : cur){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(i);
                permutation(n, visited, cur);
                visited[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Main main = new Main();
        main.solution(N);
    }
}
