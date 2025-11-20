import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine());

            int[][] table = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for(int i = 0; i < N; i++){
                int prev = 0; // 이전 상태 저장
                for(int j = 0; j < N; j++){
                    // 1. 열만 탐색
                    int n = table[j][i];
                    // 2. 0이 아닌 경우에만 처리
                    if(n != 0){
                        // 3. 현재값이 파란색일 때 이전 값이 빨간색이면 교착상태
                        if(n == 2 && prev == 1){
                            answer += 1;
                        }
                        // 4. 이전값 갱신
                        prev = n; 
                    }
                }
            }
            sb.append("#" + tc + " ").append(answer + "\n");
        }
        System.out.println(sb);
    }
}
