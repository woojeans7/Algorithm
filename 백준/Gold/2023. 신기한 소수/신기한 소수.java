import java.util.*;

/*
    BAEKJOON 2023번 신기한 소수
    https://www.acmicpc.net/problem/2023
*/

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        for(int i = 2;  i < 8; i++){
            if(isPrime(i)) dfs(0, i); // 첫째 자리 판별
        }

        list.stream().sorted().forEach(System.out::println);
    }
    public static void dfs(int depth, int num) {

        if(depth == N-1 && isPrime(num)){
            int answer = num;
            list.add(answer);
            return;
        }

        // 현재 숫자가 소수일 때만
        if(isPrime(num)){
            for(int i = 1; i < 10; i++){
                String tmp = num + "" + i; // 숫자 자릿수 이어붙이기
                int newNum = Integer.parseInt(tmp);
                dfs(depth+1, newNum);
                tmp = num + ""; // 원래대로 백트래킹
            }
        }

    }
    public static boolean isPrime(int n){
        if(n==0 || n == 1) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
