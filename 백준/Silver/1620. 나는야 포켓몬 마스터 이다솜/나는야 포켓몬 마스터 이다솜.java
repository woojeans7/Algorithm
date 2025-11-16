import java.util.*;
import java.io.*;

/*
    BAEKJOON 1620번 나는야 포켓몬 마스터 이다솜
    https://www.acmicpc.net/problem/1620
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> pokedex = new HashMap<>();
        Map<String, Integer> pokenum = new HashMap<>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            String pokemon = st.nextToken();
            pokedex.put(i, pokemon);
            pokenum.put(pokemon, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            // 만약 s가 숫자라면 숫자-문자 해시 참조
            if(Character.isDigit(s.charAt(0))){
                sb.append(pokedex.get(Integer.parseInt(s))).append("\n");
            }
            // 만약 s가 문자열이면 문자-숫자 해시 참조
            else{
                sb.append(pokenum.get(s)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
