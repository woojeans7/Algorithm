import java.io.*;
import java.util.*;

public class Main {
    private int[] val = new int[6];
    private int max = Integer.MIN_VALUE;

    public int solution(String expression) {
        boolean[] visited = new boolean[6];
        List<Character> args = new ArrayList<>();

        for (char c : expression.toCharArray()) {
            if (c >= 'a' && c <= 'f' && !visited[c - 'a']) {
                visited[c - 'a'] = true;
                args.add(c);
            }
        }

        backtrack(0, args, expression);
        return max;
    }

    private void backtrack(int depth, List<Character> args, String expression) {
        if (depth == args.size()) {
            max = Math.max(max, evaluate(expression));
            return;
        }
        for (int v = 1; v <= 4; v++) {
            val[args.get(depth) - 'a'] = v;
            backtrack(depth + 1, args, expression);
        }
    }

    private int evaluate(String expression) {
        int result = val[expression.charAt(0) - 'a'];

        for (int i = 1; i < expression.length() - 1; i += 2) {
            char op = expression.charAt(i);
            int next = val[expression.charAt(i + 1) - 'a'];
            switch (op) {
                case '+': result += next; break;
                case '-': result -= next; break;
                case '*': result *= next; break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Main main = new Main();
        System.out.println(main.solution(str));
    }
}