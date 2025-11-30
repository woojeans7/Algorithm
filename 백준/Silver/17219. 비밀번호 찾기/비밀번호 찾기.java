import java.util.*;
import java.io.*;

/*
    BAEKJOON 17219번 비밀번호 찾기
    https://www.acmicpc.net/problem/17219
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            System.out.println(map.get(key));
        }


    }
}
