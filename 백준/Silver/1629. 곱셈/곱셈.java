import java.util.*;
import java.io.*;

/*
    BAEKJOON 1629번 곱셈
    https://www.acmicpc.net/problem/1629
*/

public class Main {
    static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long result = multiply(A, B);
        System.out.println(result);

    }
    public static long multiply(long A, long B) {
        // 기저 조건
        if (B > 0) {
            // 짝수 제곱일 경우 A^2를 B/2번 곱하는 것과 같음
            if(B % 2 == 0){
                return multiply(A * A % C, B/2);
            }
            // 홀수일 경우 -1로 짝수로 만듬
            return A * multiply(A, B-1) % C;
        }
        return 1;
    }
}
