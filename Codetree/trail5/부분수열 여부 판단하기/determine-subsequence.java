import java.io.*;
import java.util.*;

public class Main {
    public boolean solution(int[] arr1, int[] arr2) {

        int j = 0;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] == arr2[j]){
                j++;
            }

            if(j == arr2.length) return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Main main = new Main();
        System.out.println(main.solution(A, B) ? "Yes" : "No");
    }
}
