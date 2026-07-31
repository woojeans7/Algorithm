import java.io.*;
import java.util.*;

public class Main {
    public int solution(int n) {
        for(int i = n / 5; i >= 0; i--){
            int rem = n - i * 5;
            if(rem % 2 == 0){
                return i + rem / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Main main = new Main();
        System.out.println(main.solution(N));
    }
}
