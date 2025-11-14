import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] money = new Integer[N];
        for(int i = 0; i < N; i++){
            money[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(money, (a, b) -> b - a);

        int count = 0;
        for(int coin : money){
            if(coin > K) continue;
            count += K / coin;
            K %= coin;
        }

        System.out.println(count);
    }
}
