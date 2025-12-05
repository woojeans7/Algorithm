import java.util.*;
import java.io.*;

/*
    BAEKJOON 1268번 임시 반장 정하기
    https://www.acmicpc.net/problem/1268
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[][] classes = new  int[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] count = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 5; k++){
                    if(classes[i][k] == classes[j][k]){
                        count[i] = count[i] + 1;
                        break;
                    }
                }
            }
        }

        int ans = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(count[i] > max){
                max = count[i];
                ans = i + 1;
            }
        }
        System.out.println(ans);
    }
}
