import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B, (a,b) -> b-a);

        int answer = 0;
        for(int i = 0; i < n; i++){
            answer += A[i] * B[i];
        }

        System.out.println(answer);
    }
}
