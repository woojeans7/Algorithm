import  java.util.*;
import java.io.*;

public class Main {
    Map<Integer, Integer> memo = new HashMap<>();

    public int fibonacci(int n) {
        memo.put(1, 1);
        memo.put(2, 1);
        for (int i = 3; i <= n; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        Main main = new Main();
        System.out.println(main.fibonacci(N));

    }
}
