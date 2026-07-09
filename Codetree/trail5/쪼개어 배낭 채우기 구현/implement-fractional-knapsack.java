import java.io.*;
import java.util.*;

public class Main {
    public double solution(int m, int[][] jewels) {

        Arrays.sort(jewels, (a, b) -> {
            int ratioA = a[1] * b[0];
            int ratioB = b[1] * a[0];
            if (ratioA == ratioB) return 0;
            return ratioA > ratioB ? -1 : 1;
        });

        double total = 0;
        for(int[] jewel : jewels) {
            int w =  jewel[0];
            int v =  jewel[1];

            if(w <= m){
                total += v;
                m -= w;
            }
            else{
                total += v * ((double) m / w);
                break;
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.printf("%.3f%n", main.solution(M, A));
    }
}
