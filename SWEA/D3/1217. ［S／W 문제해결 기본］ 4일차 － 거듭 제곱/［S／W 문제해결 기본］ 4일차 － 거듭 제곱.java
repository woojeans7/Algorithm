import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int tc = 1; tc <= 10; tc++){
            int T = in.nextInt();
            int N = in.nextInt();
            int M = in.nextInt();

            int answer = dfs(N,M);
            System.out.println("#" + T + " " + answer);
        }
    }
    public static int dfs(int n, int k) {

        if(k == 0) return 1;

        int answer = n * dfs(n, k-1);
        return answer;
    }
}
