import java.io.*;
import java.util.*;

public class Main {
    List<List<Integer>> answer = new ArrayList<>();

    public void solution(int k, int n) {
        backtrack(k, n, new ArrayList<>());

        for(List<Integer> list : answer) {
            for(int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
    private void backtrack(int k, int n, List<Integer> cur){

        if(cur.size() == n){
            answer.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 1; i <= k; i++){
            int size = cur.size();
            if(size >= 2 && cur.get(size - 1) == i && cur.get(size - 2) == i){
                continue;
            }
            cur.add(i);
            backtrack(k, n, cur);
            cur.remove(cur.size()-1);
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
