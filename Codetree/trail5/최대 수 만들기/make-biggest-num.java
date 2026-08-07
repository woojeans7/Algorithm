import java.io.*;
import java.util.*;

public class Main {
    public String solution(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num : nums){
            list.add(String.valueOf(num));
        }

        list.sort((a, b) -> {
            long o1 = Long.parseLong(a + b);
            long o2 = Long.parseLong(b + a);

            return Long.compare(o2, o1);
        });

        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
